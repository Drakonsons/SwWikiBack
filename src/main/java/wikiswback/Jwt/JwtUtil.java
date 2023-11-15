package wikiswback.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import wikiswback.auth.AuthRequest;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private static Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode("SECRETKEYquiEstSuperLongSaGrandJeTeLeDisMoiMonAmi");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static String createToken(Map<String, Object> claims, AuthRequest user) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60  ))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact() ;
    }


    public static String generateToken(AuthRequest authRequest){ // on crée un token avec les claims, les claims sont les
        // données que l'on veut stocker dans le token ***** A REMPLACER AVEC UN DTO
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "ROLE_USER");
        return createToken(claims, authRequest);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);

    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    public Boolean validateToken(String token, UserPrincipal userPrincipal) {
        final String username = extractUsername(token);
        return (username.equals(userPrincipal.getUsername()) &&
                !isTokenExpired(token));
    }



}

package wikiswback.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wikiswback.User.UserEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private final KeyService keyService;

    @Autowired
    public JwtUtil(KeyService keyService) {
        this.keyService = keyService;
    }

    public String generateToken(UserEntity user) {

        Map<String, Object> claim = new HashMap<>();
        claim.put("id", user.getId());
        claim.put("username", user.getUsername());
        claim.put("email", user.getEmail());
        return createToken(claim, user.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 10))
                .signWith(this.keyService.getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(this.keyService.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserPrincipal user) {
        final String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


}

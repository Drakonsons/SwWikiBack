package wikiswback.Jwt;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class KeyService {

    public Key getKey() {

        byte[] keyBytes = Decoders.BASE64.decode("SECRETKEYquiEstSuperLongSaGrandJeTeLeDisMoiMonAmi");

        return Keys.hmacShaKeyFor(keyBytes);

    }
}

package jwtdemo.service;

/**
 * Created by nhs3108 on 29/03/2017.
 */
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
public class TokenAuthenticationService {	
	 	private static final Key secret = MacProvider.generateKey(SignatureAlgorithm.HS256);
	    private static final byte[] secretBytes = secret.getEncoded();
	    private static final String base64SecretBytes = Base64.getEncoder().encodeToString(secretBytes);
	    
	    public static String generateToken(String userName) {
	        String id = UUID.randomUUID().toString().replace("-", "");
	        Date now = new Date();
	        Date exp = new Date(System.currentTimeMillis() + (1000 * 30)); // 30 seconds
	        String token = Jwts.builder()
	            .setId(id)
	            .setIssuedAt(now)
	            .setNotBefore(now)
	            .setExpiration(exp)
	            .setSubject(userName)
	            .signWith(SignatureAlgorithm.HS256, base64SecretBytes)
	            .compact();
	        return token;
	    }
	    public static void verifyToken(String token) {
	        Claims claims = Jwts.parser()
	            .setSigningKey(base64SecretBytes)
	            .parseClaimsJws(token).getBody();
	        System.out.println("----------------------------");
	        System.out.println("ID: " + claims.getId());
	        System.out.println("Subject: " + claims.getSubject());
	        System.out.println("Issuer: " + claims.getIssuer());
	        System.out.println("Expiration: " + claims.getExpiration());
	    }
	
}
	
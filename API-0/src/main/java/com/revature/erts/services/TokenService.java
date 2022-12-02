package services;

import dtos.responses.Principal;
import models.DatatypeCrossRef;
import com.revature.erts.models.UserRole;
import com.revature.erts.utils.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.sql.Timestamp;

public class TokenService {
    private JwtConfig jwtConfig;

    public TokenService() {
        super();
    }

    public TokenService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(Principal subject) {
        long now = System.currentTimeMillis();
        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(subject.getUserUUID())
                .setIssuer("erts")
                .setIssuedAt(new Timestamp(now))
                .setExpiration(new Timestamp(now + jwtConfig.getExpiration()))
                .setSubject(subject.getUsername())
                .claim("user_role", subject.getRole())
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        return tokenBuilder.compact();
    }

    public Principal extractRequesterDetails(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();
            return new Principal(claims.getUserID(), claims.getSubject(),
                    DatatypeCrossRef.userRoleUUID2Enum(claims.get("user_role", String.class)));
        } catch (Exception e) {
            return null;
        }
    }
}


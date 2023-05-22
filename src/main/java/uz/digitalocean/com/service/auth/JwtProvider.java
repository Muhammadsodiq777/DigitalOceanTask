package uz.digitalocean.com.service.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.exception.NotFoundCustomException;

import java.util.Date;

@Service
public class JwtProvider {

    @Value("${jwt.access.token.secret.key}")
    private String accessSecretKey;

    @Value("${jwt.refresh.token.secret.key}")
    private String refreshSecretKey;

    public String generateAccessToken(Student student) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, accessSecretKey)
                .setSubject(student.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60))
                .claim("authorities", student.getPermissions())
                .compact();
    }

    public String generateRefreshToken(Student student) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, refreshSecretKey)
                .setSubject(student.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 24))
                .claim("authorities", student.getAuthorities())
                .compact();
    }

    public Claims parseAccessToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(accessSecretKey)
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new NotFoundCustomException("access token expired");
        } catch (Exception e) {
            return null;
        }
    }

    public String parseRefreshToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(refreshSecretKey)
                    .parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            throw new NotFoundCustomException("refresh token expired");
        } catch (Exception e) {
            return null;
        }
    }

}

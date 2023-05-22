package uz.digitalocean.com.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.service.auth.AuthService;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final AuthService authService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if(token == null) {
//            throw new JwtException("Token not found or invalid");
            filterChain.doFilter(request, response);
            return;
        }

        if(!token.startsWith("Bearer "))
            throw new JwtException("Token invalid");

        token = token.replace("Bearer ", "");
        Claims claims = this.parseToken(token);

        Student student = (Student) authService.loadUserByUsername(claims.getSubject());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                student.getPassword(),
                null,
                student.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }

    private Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey("nnn")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            throw new ExpiredJwtException(null, null, "expired date");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new JwtException("secret key error");
        }
    }

}

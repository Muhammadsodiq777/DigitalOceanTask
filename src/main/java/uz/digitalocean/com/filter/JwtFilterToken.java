package uz.digitalocean.com.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.auth.JwtProvider;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilterToken extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String authorization = request.getHeader("Authorization");

            if(authorization == null) {
                filterChain.doFilter(request, response);
                return;
            }

            String accessToken = authorization.replace("Bearer ", "");

            Claims claims = jwtProvider.parseAccessToken(accessToken);

            Student student = new Student();
            student.setPermissions((String) claims.get("authorities"));

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    claims.getSubject(),
                    null,
                    student.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            setErrorResponse(response, ex.getMessage());
        }

    }

    private void setErrorResponse(
            HttpServletResponse response,
            String message) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        ResponseDataDto responseDataDto = new ResponseDataDto<>(false, 1000, message, null);
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(responseDataDto));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package uz.digitalocean.com.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.repository.StudentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final StudentRepository repository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }


    public String getAccessToken(String refreshToken) {
        String username = jwtProvider.parseRefreshToken(refreshToken);
        Optional<Student> optionalUserEntity = repository.findByUsername(username);

        if(optionalUserEntity.isEmpty())
            throw new UsernameNotFoundException(username + " not found");

        return jwtProvider.generateAccessToken(optionalUserEntity.get());

    }

}

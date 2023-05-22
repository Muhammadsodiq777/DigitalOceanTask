package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.digitalocean.com.service.auth.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/refresh/token")
    public String getAccessToken(
            @RequestBody Map<String, String> authorization
    ) {
        String refreshToken = authorization.get("refresh_token");
        return authService.getAccessToken(refreshToken);
    }


}

package br.com.issler.acheiQI.controllers;

import br.com.issler.acheiQI.dtos.LoginDTO;
import br.com.issler.acheiQI.dtos.RegisterDTO;
import br.com.issler.acheiQI.dtos.TokenResponse;
import br.com.issler.acheiQI.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@Valid @RequestBody RegisterDTO dto) throws Exception {
        authService.register(dto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse login(@Valid @RequestBody LoginDTO dto) throws Exception {
        String token = authService.login(dto);

        return TokenResponse.builder().token(token).build();
    }
}

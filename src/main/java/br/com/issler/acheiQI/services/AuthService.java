package br.com.issler.acheiQI.services;

import br.com.issler.acheiQI.database.models.UserEntity;
import br.com.issler.acheiQI.database.repositories.IUserRepository;
import br.com.issler.acheiQI.dtos.LoginDTO;
import br.com.issler.acheiQI.dtos.RegisterDTO;
import br.com.issler.acheiQI.exceptions.BadRequestException;
import br.com.issler.acheiQI.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    public void register(RegisterDTO dto) throws Exception {
        // verifica se um usuario com o mesmo email já existe
        UserEntity user = userRepository.findByEmail(dto.email()).orElse(null);
        if(user != null){
            throw new BadRequestException("Usuário com este e-mail já existe");
        }

        try {
            userRepository.save(UserEntity.builder()
                    .name(dto.name())
                    .email(dto.email())
                    .password(passwordEncoder.encode(dto.password())) // criptografa a senha antes de salvar no banco
                    .phone(dto.phone())
                    .affiliation(dto.qiAffiliation())
                    .unit(dto.qiUnit())
                    .build());
        } catch (Exception e) {
            throw new Exception("Erro ao registrar usuário no sistema");
        }
    }

    public String login(LoginDTO dto) throws Exception {
        try{

            // tentar logar usuario
            // por debaixo dos panos, o spring security vai chamar o UserDetailsServiceImpl.loadUserByUsername() para buscar o usuario no banco de dados
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.email(), dto.password()
                    )
            );

            return tokenProvider.generate(auth);
        } catch (BadCredentialsException e){
            throw new BadRequestException("E-mail ou senha inválidos");
        } catch (Exception e){
            throw new Exception("Erro ao tentar logar usuário");
        }
    }
}

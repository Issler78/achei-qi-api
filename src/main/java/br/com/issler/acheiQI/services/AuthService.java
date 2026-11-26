package br.com.issler.acheiQI.services;

import br.com.issler.acheiQI.database.models.UserEntity;
import br.com.issler.acheiQI.database.repositories.IUserRepository;
import br.com.issler.acheiQI.dtos.RegisterDTO;
import br.com.issler.acheiQI.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}

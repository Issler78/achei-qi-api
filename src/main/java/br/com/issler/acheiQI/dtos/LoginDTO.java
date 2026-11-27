package br.com.issler.acheiQI.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginDTO(
        @NotBlank
        String email,
        @NotBlank
        String password
) { }

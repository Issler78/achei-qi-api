package br.com.issler.acheiQI.dtos;

import lombok.Builder;

@Builder
public record TokenResponse(
        String token
) {
}

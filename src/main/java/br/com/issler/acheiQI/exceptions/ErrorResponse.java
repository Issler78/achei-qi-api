package br.com.issler.acheiQI.exceptions;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String message,
        int status
) {}

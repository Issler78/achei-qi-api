package br.com.issler.acheiQI.dtos;

import br.com.issler.acheiQI.enums.qiAffiliationEnum;
import br.com.issler.acheiQI.enums.qiUnitEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegisterDTO(
        @NotBlank
        @Size(max = 150)
        String name,

        @NotBlank
        @Size(max = 200)
        String email,

        @NotBlank
        @Size(min = 6)
        String password,

        @NotBlank
        @Size(min = 11, max = 11)
        String phone,

        @NotNull
        qiAffiliationEnum qiAffiliation,

        @NotNull
        qiUnitEnum qiUnit
) {}
package br.com.issler.acheiQI.dtos;

import br.com.issler.acheiQI.enums.itemCategoryEnum;
import br.com.issler.acheiQI.enums.qiUnitEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateItemDTO(
        @NotBlank
        String title,

        String description,

        @NotNull
        itemCategoryEnum category,

        @NotBlank
        String imageBase64,

        @NotBlank
        String location,

        @NotNull
        qiUnitEnum unit
) {}

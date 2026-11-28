package br.com.issler.acheiQI.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum itemCategoryEnum {
    SCHOOL_SUPPLIES("Materiais Escolares"),
    DOCUMENTS("Documentos"),
    ELECTRONICS("Eletrônicos"),
    CLOTHING("Vestuário"),
    OTHER("Outro");

    private final String value;

    itemCategoryEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

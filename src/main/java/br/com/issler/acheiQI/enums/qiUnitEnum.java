package br.com.issler.acheiQI.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum qiUnitEnum {
    ALVORADA("Alvorada"),
    CANOAS("Canoas"),
    CAXIAS_DO_SUL("Caxias do Sul"),
    ESTEIO("Esteio"),
    GRAVATAI("Gravataí"),
    GUAIBA("Guaíba"),
    NOVO_HAMBURGO("Novo Hamburgo"),
    PORTO_ALEGRE_ALBERTO_BINS("Porto Alegre - Alberto Bins"),
    PORTO_ALEGRE_ASSIS_BRASIL("Porto Alegre - Assis Brasil"),
    PORTO_ALEGRE_JUCA_BATISTA("Porto Alegre - Juca Batista"),
    RIO_GRANDE("Rio Grande"),
    SAO_LEOPOLDO("São Leopoldo"),
    VIAMAO("Viamão");

    private final String value;

    qiUnitEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

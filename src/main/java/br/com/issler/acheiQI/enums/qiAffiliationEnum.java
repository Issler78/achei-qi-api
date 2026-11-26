package br.com.issler.acheiQI.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum qiAffiliationEnum {
    STUDENT("Aluno QI"),
    TEACHER("Professor QI"),
    EMPLOYEE("Funcionário QI");

    private final String value;

    qiAffiliationEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

package com.cloud.partidinha.domain.enums;

public enum PixType {
    IDENTIFICATION_DOCUMENT("cpf/cnpj"),
    RANDOM("chave_aleatoria"),
    EMAIL("email"),
    PHONE("telefone");

    private String value;

    PixType(String value) {
        this.value = value;
    }
}

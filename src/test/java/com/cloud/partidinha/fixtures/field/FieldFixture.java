package com.cloud.partidinha.fixtures.field;

import com.cloud.partidinha.domain.Field;

public class FieldFixture {

    public static Field getOneValid() {
        return Field
                .builder()
                .name("campo")
                .cost("320.00")
                .location("Localidade")
                .capacity(50)
                .description("Um campo")
                .build();
    }

    public static Field getOneInvalid() {
        return Field
                .builder()
                .name("campo")
                .cost("320.0")
                .location("Localidade")
                .capacity(50)
                .description("Um campo")
                .build();
    }
}

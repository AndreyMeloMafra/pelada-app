package com.cloud.partidinha.domain.enums;

public enum PlayerPosition {
    GOALKEEPER("Goleiro"),
    DEFENSE("Defensor"),
    MIDDLEFIELD("Meio-campo"),
    ATTACK("Atacante");

    private String value;

    PlayerPosition(String value) {
        this.value = value;
    }
}

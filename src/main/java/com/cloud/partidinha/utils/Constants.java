package com.cloud.partidinha.utils;

public class Constants {

    public static final String PATTERN_ERROR = "pattern inválido";
    public static final String FLOAT_NUMBER_PATTERN = "^[0-9]*[.][0-9]{2}";
    public static final String NOT_BLANK_MESSAGE = "não deve estar vazio ou nulo";
    public static final String NOT_NULL_MESSAGE = "não deve estar nulo";

    // user
    public static final String PLAYER_POSITION_PATTERN = "GOALKEEPER|DEFENSE|MIDDLEFIELD|ATTACK";
    public static final int PLAYER_POSITION_MIN_SIZE = 1;
    public static final int PLAYER_POSITION_MAX_SIZE = 3;
    public static final String PLAYER_POSITION_SIZE_MESSAGE = "deve ter tamanho entre 1 e 3";

    // pixtype
    public static final String PIX_TYPE_PATTERN = "IDENTIFICATION_DOCUMENT|RANDOM|EMAIL|PHONE";

}

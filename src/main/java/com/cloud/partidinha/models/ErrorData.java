package com.cloud.partidinha.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorData {

    private String title;
    private String description;
    private Integer code;
}

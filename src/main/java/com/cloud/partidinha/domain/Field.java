package com.cloud.partidinha.domain;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.cloud.partidinha.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Container(containerName = "campo", ru = "400")
public class Field {

    @Id
    @GeneratedValue
    private String id;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.FLOAT_NUMBER_PATTERN, message = Constants.PATTERN_ERROR)
    private String cost;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private String location;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Integer capacity;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private String description;
}

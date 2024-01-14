package com.cloud.partidinha.models;

import com.cloud.partidinha.domain.enums.PixType;
import com.cloud.partidinha.utils.Constants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Pix {
    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private String key;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Pattern(regexp = Constants.PIX_TYPE_PATTERN, message = Constants.PATTERN_ERROR)
    private PixType type;
}

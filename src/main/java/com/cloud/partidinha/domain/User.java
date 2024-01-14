package com.cloud.partidinha.domain;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.cloud.partidinha.domain.enums.PlayerPosition;
import com.cloud.partidinha.models.Pix;
import com.cloud.partidinha.utils.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@Container(containerName = "user")
public class User {

    @Id
    @GeneratedValue
    private String id;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private String firstName;
    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private String lastName;
    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private String nickName;

    @Valid
    private Pix pix;
    private String team;
    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = Constants.PLAYER_POSITION_MIN_SIZE, max = Constants.PLAYER_POSITION_MAX_SIZE, message = Constants.PLAYER_POSITION_SIZE_MESSAGE)
    private List<@Pattern(regexp = Constants.PLAYER_POSITION_PATTERN) PlayerPosition> playerPosition;
}

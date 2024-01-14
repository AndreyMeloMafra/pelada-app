package com.cloud.partidinha.exceptions;

import com.cloud.partidinha.models.ErrorData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class InternalServerError extends RuntimeException {

    private final List<ErrorData> errorDataList;
}

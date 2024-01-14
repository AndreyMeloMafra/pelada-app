package com.cloud.partidinha.handlers;

import com.cloud.partidinha.exceptions.InternalServerError;
import com.cloud.partidinha.models.ErrorData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class InternalServerErrorHandler {
    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<List<ErrorData>> handleInternalServerError(final InternalServerError exception) {
        log.warn("EXCEPTION");
        return ResponseEntity.status(500).body(exception.getErrorDataList());
    }
}

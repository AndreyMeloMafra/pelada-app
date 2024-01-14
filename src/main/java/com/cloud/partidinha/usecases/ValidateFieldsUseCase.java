package com.cloud.partidinha.usecases;

import com.cloud.partidinha.exceptions.InternalServerError;
import com.cloud.partidinha.models.ErrorData;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ValidateFieldsUseCase<T> {

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    private final String TITLE = "Erro de validação de campo";
    private final Integer CODE = 400;

    public void execute(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);

        List<ErrorData> errors = new ArrayList<>();
        violations.forEach((ConstraintViolation<T> constraintViolation) -> {
                    errors.add(ErrorData
                            .builder()
                            .title(TITLE)
                            .description(String.format("O campo %s gerou o erro: %s",
                                    constraintViolation.getPropertyPath().toString(),
                                    constraintViolation.getMessage()))
                            .code(CODE)
                            .build());
                }
        );

        if (!errors.isEmpty()) {
            throw new InternalServerError(errors);
        }
    }
}

package com.cloud.partidinha.usecases.field;

import com.cloud.partidinha.domain.Field;
import com.cloud.partidinha.repository.FieldRepository;
import com.cloud.partidinha.usecases.ValidateFieldsUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFieldUseCase {
    private final ValidateFieldsUseCase<Field> validateFieldsUseCase;
    private final Logger logger = LoggerFactory.getLogger(CreateFieldUseCase.class.getName());

    @Autowired
    private final FieldRepository fieldRepository;

    public Field execute(Field field) {
        logger.info("Start post Campo Operation");
        validateFieldsUseCase.execute(field);

        Field fieldResult = fieldRepository.save(field).block();
        logger.info("End post Campo Operation");
        return fieldResult;
    }
}

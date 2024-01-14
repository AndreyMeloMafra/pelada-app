package com.cloud.partidinha.usecases.field;

import com.cloud.partidinha.domain.Field;
import com.cloud.partidinha.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindFieldsByName {
    private final Logger logger = LoggerFactory.getLogger(CreateFieldUseCase.class.getName());

    @Autowired
    private final FieldRepository fieldRepository;
    public List<Field> execute(String name) {
        logger.info("Start get Campo Operation");

        Flux<Field> campos = fieldRepository.getCampoByName(name);
        logger.info("End get Campo Operation");
        return campos.collect(Collectors.toList()).block();
    }
}

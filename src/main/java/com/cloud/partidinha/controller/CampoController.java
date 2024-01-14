package com.cloud.partidinha.controller;

import com.cloud.partidinha.domain.Campo;
import com.cloud.partidinha.repository.CampoRepository;
import com.cloud.partidinha.usecases.ValidateFieldsUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/campos")
@RequiredArgsConstructor
public class CampoController {

    private final ValidateFieldsUseCase<Campo> validateFieldsUseCase;
    private final Logger logger = LoggerFactory.getLogger(CampoController.class.getName());

    @Autowired
    private final CampoRepository campoRepository;

    @PostMapping(path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Campo save(@RequestBody Campo campo) {
        logger.info("Start post Campo Operation");
        validateFieldsUseCase.execute(campo);

        Campo campoResult = campoRepository.save(campo).block();
        logger.info("End post Campo Operation");
        return campoResult;
    }

    @GetMapping(path = "/")
    public List<Campo> findAll() {
        logger.info("Start get Campo Operation");

        Flux<Campo> campos = campoRepository.findAll();
        logger.info("End get Campo Operation");
        return campos.collect(Collectors.toList()).block();
    }

    @GetMapping(path = "/getByName")
    public List<Campo> findByName(@RequestParam("name") String name) {
        logger.info("Start get Campo Operation");

        Flux<Campo> campos = campoRepository.getCampoByName(name);
        logger.info("End get Campo Operation");
        return campos.collect(Collectors.toList()).block();
    }
}

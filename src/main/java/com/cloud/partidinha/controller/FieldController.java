package com.cloud.partidinha.controller;

import com.cloud.partidinha.domain.Field;
import com.cloud.partidinha.usecases.field.CreateFieldUseCase;
import com.cloud.partidinha.usecases.field.FindAllFields;
import com.cloud.partidinha.usecases.field.FindFieldsByName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/campos")
@RequiredArgsConstructor
public class FieldController {
    private final CreateFieldUseCase createFieldUseCase;
    private final FindAllFields findAllFields;
    private final FindFieldsByName findFieldsByName;

    @PostMapping(path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Field> save(@RequestBody Field field) {
        Field fieldCreated = createFieldUseCase.execute(field);

        return ResponseEntity.status(HttpStatus.OK).body(fieldCreated);
    }

    @GetMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Field>> findAll() {
        List<Field> fields = findAllFields.execute();

        return ResponseEntity.status(HttpStatus.OK).body(fields);
    }

    @GetMapping(path = "/getByName",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Field>> findByName(@RequestParam("name") String name) {
        List<Field> fields = findFieldsByName.execute(name);

        return ResponseEntity.status(HttpStatus.OK).body(fields);
    }
}

package com.cloud.partidinha.usecases.field;

import com.cloud.partidinha.domain.Field;
import com.cloud.partidinha.exceptions.InternalServerError;
import com.cloud.partidinha.fixtures.field.FieldFixture;
import com.cloud.partidinha.models.ErrorData;
import com.cloud.partidinha.repository.FieldRepository;
import com.cloud.partidinha.usecases.ValidateFieldsUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateFieldUseCaseTest {

    ValidateFieldsUseCase<Field> validateFieldsUseCase = new ValidateFieldsUseCase<>();
    FieldRepository fieldRepository = Mockito.mock(FieldRepository.class);
    private final CreateFieldUseCase createFieldUseCase;

    public CreateFieldUseCaseTest() {
        createFieldUseCase = new CreateFieldUseCase(
                validateFieldsUseCase,
                fieldRepository
        );
    }

    @DisplayName("Deve ser possível criar um campo")
    @Test
    void shouldCreateField() {
        // given: Campo Válido
        Field field = FieldFixture.getOneValid();
        Mono<Field> fieldFlux = Mono.just(field);
        fieldFlux.block().setId("id");

        Mockito.when(fieldRepository.save(field)).thenReturn(fieldFlux);

        // when: useCase é chamado
        Field fieldResult = assertDoesNotThrow(() -> createFieldUseCase.execute(field));

        // then: é validado
        assertAll(
                () -> assertEquals(field.getId(), fieldResult.getId()),
                () -> assertEquals(field.getName(), fieldResult.getName()),
                () -> assertEquals(field.getCost(), fieldResult.getCost()),
                () -> assertEquals(field.getLocation(), fieldResult.getLocation()),
                () -> assertEquals(field.getDescription(), fieldResult.getDescription()),
                () -> assertEquals(field.getCapacity(), fieldResult.getCapacity())
        );
    }

    @DisplayName("Não deve ser possível criar um campo por erro de validação")
    @Test
    void shouldNotCreateFieldWhenHasInvalidValue() {
        // given: Campo Válido
        Field field = FieldFixture.getOneInvalid();

        // when: useCase é chamado
        InternalServerError error = assertThrows(
                InternalServerError.class,
                () -> createFieldUseCase.execute(field),
                "Expected doThing() to throw, but it didn't"
        );

        List<ErrorData> errors = error.getErrorDataList();
        assertEquals(1, errors.size());

        // then: é validado
        assertAll(
                () -> assertEquals("Erro de validação de campo", errors.get(0).getTitle()),
                () -> assertEquals("O campo cost gerou o erro: pattern inválido", errors.get(0).getDescription()),
                () -> assertEquals(400, errors.get(0).getCode())
        );
    }
}
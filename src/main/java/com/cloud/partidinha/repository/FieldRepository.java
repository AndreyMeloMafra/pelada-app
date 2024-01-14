package com.cloud.partidinha.repository;

import com.azure.spring.data.cosmos.repository.Query;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.cloud.partidinha.domain.Field;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FieldRepository extends ReactiveCosmosRepository<Field, String> {
    @Query("select * from c where c.name = @name")
    Flux<Field> getCampoByName(@Param("name") String name);
}

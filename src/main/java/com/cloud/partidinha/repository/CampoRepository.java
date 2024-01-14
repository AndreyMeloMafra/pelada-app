package com.cloud.partidinha.repository;

import com.azure.spring.data.cosmos.repository.Query;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.cloud.partidinha.domain.Campo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CampoRepository extends ReactiveCosmosRepository<Campo, String> {
    @Query("select * from c where c.name = @name")
    Flux<Campo> getCampoByName(@Param("name") String name);
}

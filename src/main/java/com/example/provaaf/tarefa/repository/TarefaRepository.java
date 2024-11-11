package com.example.provaaf.tarefa.repository;

import com.example.provaaf.tarefa.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, String> {
}

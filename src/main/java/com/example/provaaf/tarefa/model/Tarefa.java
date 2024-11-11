package com.example.provaaf.tarefa.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class Tarefa {

    @Id
    String id;
    String descricao;
    LocalDateTime prazo;
}

package com.example.provaaf.tarefa.controller;

import com.example.provaaf.tarefa.model.Tarefa;
import com.example.provaaf.tarefa.service.TarefaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa criarAvaliacao(@RequestBody Tarefa tarefa, @RequestHeader(name = "Authorization") String jwtToken) {
        return tarefaService.criaTarefa(tarefa,jwtToken);
    }

    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@RequestParam String id, @RequestHeader(name = "Authorization") String jwtToken) {
        tarefaService.deletaTarefa(id,jwtToken);
    }

    @GetMapping("{id}")
    public Tarefa pegaAvaliacao(@RequestParam String id, @RequestHeader(name = "Authorization") String jwtToken) {
        return tarefaService.getTarefa(id,jwtToken);
    }

    @GetMapping
    public List<Tarefa> listaTarefas(@RequestHeader(name = "Authorization") String jwtToken) {
        return tarefaService.listaTarefa(jwtToken);
    }
}

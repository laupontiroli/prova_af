package com.example.provaaf.tarefa.service;

import com.example.provaaf.tarefa.model.Tarefa;
import com.example.provaaf.tarefa.repository.TarefaRepository;
import com.example.provaaf.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarefaService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TarefaRepository tarefaRepository;
    public Tarefa criaTarefa(Tarefa tarefa, String jwtToken){

        String papel = usuarioService.pegaPapel(jwtToken);
        if (papel.equals("none")){
            throw new RuntimeException("token inválido");
        }
        else if (papel.equals("DEVELOPER")){
            throw new RuntimeException("Criação é feita por ADMIN");
        }
        tarefa.setId(UUID.randomUUID().toString());
        return tarefaRepository.save(tarefa);
    }

    public void deletaTarefa(String id, String jwtToken){
        String papel = usuarioService.pegaPapel(jwtToken);
        if (papel.equals("none")){
            throw new RuntimeException("token inválido");
        }
        else if (papel.equals("DEVELOPER")){
            throw new RuntimeException("Criação é feita por ADMIN");
        }
        Optional<Tarefa> op = tarefaRepository.findById(id);

        if (op.isPresent()){
            Tarefa tarefa = op.get();
            tarefaRepository.delete(tarefa);
        }
        throw new RuntimeException("tarefa não encontrada");
    }

    public List<Tarefa> listaTarefa(String jwtToken){
        String papel = usuarioService.pegaPapel(jwtToken);
        if (papel.equals("none")){
            throw new RuntimeException("token inválido");
        }
        return tarefaRepository.findAll();
    }

    public Tarefa getTarefa(String id,String jwtToken){
        String papel = usuarioService.pegaPapel(jwtToken);
        if (papel.equals("none")){
            throw new RuntimeException("token inválido");
        }
        Optional<Tarefa> op = tarefaRepository.findById(id);

        if (op.isPresent()){
            return op.get();
        }
        throw new RuntimeException("tarefa não encontrada");
    }
}

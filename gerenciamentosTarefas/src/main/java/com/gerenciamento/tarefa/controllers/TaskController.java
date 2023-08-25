package com.gerenciamento.tarefa.controllers;

import com.gerenciamento.tarefa.dtos.TaskDTO;
import com.gerenciamento.tarefa.entities.Task;
import com.gerenciamento.tarefa.repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping
    public ResponseEntity listar(){
        var listar = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listar);
    }

    @PostMapping
    public ResponseEntity postar(@RequestBody @Valid TaskDTO taskDTO){
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarTarefa(@PathVariable Long id){
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid TaskDTO taskDTO){
        Optional<Task> task0 = repository.findById(id);
        if (task0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }else{
            var task = task0.get();
            BeanUtils.copyProperties(taskDTO,task);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(task));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }else{
            repository.delete(task.get());
            return ResponseEntity.status(HttpStatus.OK).body("Tarefa apagada com sucesso");
        }
    }

}

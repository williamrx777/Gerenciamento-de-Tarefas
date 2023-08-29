package com.gerenciamento.tarefa.repositories;

import com.gerenciamento.tarefa.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}

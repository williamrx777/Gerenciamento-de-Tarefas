package com.gerenciamento.tarefa.dtos;

import com.gerenciamento.tarefa.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

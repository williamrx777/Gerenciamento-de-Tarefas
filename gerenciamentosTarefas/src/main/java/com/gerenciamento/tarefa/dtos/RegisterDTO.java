package com.gerenciamento.tarefa.dtos;

import com.gerenciamento.tarefa.entities.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotBlank String login,@NotBlank String password,@NotNull UserRole role) {
}

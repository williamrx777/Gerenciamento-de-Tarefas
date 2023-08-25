package com.gerenciamento.tarefa.dtos;

import com.gerenciamento.tarefa.entities.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskDTO(@NotBlank String titulo, @NotBlank String descricao, @NotNull LocalDate data_inicio,@NotNull LocalDate data_limite,@NotNull Status status) {
}

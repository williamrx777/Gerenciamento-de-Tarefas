package com.gerenciamento.tarefa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "tasks")
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {
    // ID, título, descrição, data de criação, data limite e status.
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String titulo;
    private String descricao;
    private LocalDate data_inicio;
    private LocalDate data_limite;
    @Enumerated
    private Status status;

}

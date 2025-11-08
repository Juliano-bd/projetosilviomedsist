package com.medisist.medisist.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@ToString(exclude = "consultas")
@EqualsAndHashCode(exclude = "consultas")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true) // Telefone pode ser opcional
    private String telefone;

    @Column(nullable = false, unique = true) // CPF deve ser único
    private String cpf;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;
}
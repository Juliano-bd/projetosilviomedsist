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
@ToString(exclude = {"consultas", "exames"})
@EqualsAndHashCode(exclude = {"consultas", "exames"})
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;

    @ManyToMany
    @JoinTable(
            name = "paciente_exame",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "exame_id")
    )
    private List<Exame> exames;
}
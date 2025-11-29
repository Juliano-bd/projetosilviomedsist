package com.medisist.medisist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "exame")
@Getter
@Setter
@ToString(exclude = "pacientes") // Evita loop infinito no log
@EqualsAndHashCode(exclude = "pacientes") // Evita loop infinito na comparação
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeExame; // Ex: Hemograma, Raio-X

    @ManyToMany(mappedBy = "exames")
    private List<Paciente> pacientes;

    public Exame() {}

    public Exame(String nomeExame) {
        this.nomeExame = nomeExame;
    }
}
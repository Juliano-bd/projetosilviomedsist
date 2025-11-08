package com.medisist.medisist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.attoparser.dom.Text;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataConsulta;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
}
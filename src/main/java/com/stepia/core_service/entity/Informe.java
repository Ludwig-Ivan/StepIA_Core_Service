package com.stepia.core_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "informes_clinicos", schema = "clinico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_informe", nullable = false, updatable = false)
    private UUID idInforme;

    @Column(name = "id_paciente", columnDefinition = "bpchar", nullable = false, length = 18)
    private String idPaciente;

    @Column(name = "id_profesional", columnDefinition = "bigint", nullable = false)
    private Long idProfesional;

    @Column(name = "estado_general", columnDefinition = "TEXT")
    private String estadoGeneral;

    @Column(name = "peso_kg", precision = 5, scale = 2)
    private BigDecimal pesoKg;

    @Column(name = "sintomas", columnDefinition = "TEXT")
    private String sintomas;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "codigo_cie10", length = 10)
    private String codigoCie10;

    @Column(name = "tratamiento", columnDefinition = "TEXT")
    private String tratamiento;

    @Column(name = "evolucion", columnDefinition = "TEXT")
    private String evolucion;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private java.sql.Timestamp fechaRegistro;

    @PrePersist
    protected void onCreate() {
        java.sql.Timestamp ahora = new java.sql.Timestamp(System.currentTimeMillis());
        this.fechaRegistro = ahora;
    }
}
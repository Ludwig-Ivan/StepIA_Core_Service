package com.stepia.core_service.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expedientes_clinicos", schema = "clinico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expediente {
    @Id
    @Column(name = "id_paciente", length = 18, columnDefinition = "bpchar", nullable = false)
    private String idPaciente;

    @Column(name = "numero_expediente", length = 30, nullable = false, unique = true)
    private String numeroExpediente;

    @Column(name = "antecedentes", columnDefinition = "TEXT")
    private String antecedentes;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @CurrentTimestamp
    @Column(name = "fecha_apertura", nullable = false)
    private java.sql.Timestamp fechaApertura;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion", nullable = false)
    private java.sql.Timestamp fechaActualizacion;

    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private java.sql.Timestamp fechaRegistro;
}
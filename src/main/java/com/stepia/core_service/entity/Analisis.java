package com.stepia.core_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "analisis_ia", schema = "documentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analisis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_analisis", nullable = false, updatable = false)
    private java.util.UUID idAnalisis;

    @Column(name = "id_informe", nullable = false)
    private java.util.UUID idInforme;

    @Column(name = "pie_type", nullable = false)
    private String pieType;

    @Column(name = "class_name", columnDefinition = "varchar", length = 10)
    private String className;

    @Column(name = "confidence", columnDefinition = "numeric", precision = 3, scale = 2)
    private BigDecimal confidence;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private java.sql.Timestamp fechaRegistro;

    @Column(name = "fecha_actualizacion", nullable = false, updatable = false)
    private java.sql.Timestamp fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        java.sql.Timestamp ahora = new java.sql.Timestamp(System.currentTimeMillis());
        this.fechaRegistro = ahora;
        this.fechaActualizacion = ahora;
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new java.sql.Timestamp(System.currentTimeMillis());
    }
}

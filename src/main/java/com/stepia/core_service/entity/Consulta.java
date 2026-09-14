package com.stepia.core_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultas", schema = "clinico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long idConsulta;

    @Column(name = "id_paciente", columnDefinition = "bpchar", nullable = false)
    private String idPaciente;

    @Column(name = "id_profesional", columnDefinition = "bigint", nullable = false)
    private Long idProfesional;

    @Column(name = "fecha_hora", nullable = false)
    private java.sql.Timestamp fechaHora;

    @Column(name = "motivo", length = 500)
    private String motivo;

    @Column(name = "estado", nullable = false, length = 30)
    private String estado = "AGENDADA";

    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    @Column(name = "id_consulta_origen")
    private Long consultaOrigen;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private java.sql.Timestamp fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private java.sql.Timestamp fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        java.sql.Timestamp ahora = new java.sql.Timestamp(System.currentTimeMillis());
        this.fechaCreacion = ahora;
        this.fechaActualizacion = ahora;
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new java.sql.Timestamp(System.currentTimeMillis());
    }
}

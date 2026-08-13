package com.stepia.core_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "pacientes", schema = "clinico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pacientes {
    @Id
    @Column(name = "curp", length = 18, columnDefinition = "bpchar", nullable = false)
    private String curp;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 100, nullable = false)
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "sexo", length = 20, nullable = false)
    private String sexo;

    @Column(name = "telefono", length = 20, nullable = true)
    private String telefono;

    @Column(name = "domicilio", length = 255, nullable = true)
    private String domicilio;

    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false)
    private java.sql.Timestamp fechaRegistro;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion", nullable = false)
    private java.sql.Timestamp fechaActualizacion;
}

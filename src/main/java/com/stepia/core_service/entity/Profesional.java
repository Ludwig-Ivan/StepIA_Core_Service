package com.stepia.core_service.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profesionales", schema = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesional")
    private Long idProfesional;

    @Column(name = "especialidad", nullable = false, length = 150)
    private String especialidad;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 100)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 100)
    private String apellidoMaterno;

    @Column(name = "cedula_profesional", nullable = false, length = 20, unique = true)
    private String cedulaProfesional;

    @Column(name = "cedula_especializada", length = 20, unique = true)
    private String cedulaEspecializada;

    @Column(name = "institucion", length = 200)
    private String institucion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "email", nullable = false, length = 254, unique = true)
    private String email;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private java.sql.Timestamp fechaRegistro;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion", nullable = false)
    private java.sql.Timestamp fechaActualizacion;
}

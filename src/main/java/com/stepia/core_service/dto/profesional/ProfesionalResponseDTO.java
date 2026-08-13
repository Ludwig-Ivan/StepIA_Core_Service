package com.stepia.core_service.dto.profesional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionalResponseDTO {

    private Long idProfesional;

    private String especialidad;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String cedulaProfesional;

    private String cedulaEspecializada;

    private String institucion;

    private String telefono;

    private String email;

    private Boolean activo;

}

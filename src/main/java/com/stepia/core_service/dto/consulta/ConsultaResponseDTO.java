package com.stepia.core_service.dto.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponseDTO {

    private Long idConsulta;

    private String idPaciente;

    private Long idProfesional;

    private java.sql.Timestamp fechaHora;

    private String motivo;

    private String estado;

    private String observaciones;

    private Long idConsultaOrigen;

    private java.sql.Timestamp fechaCreacion;

    private java.sql.Timestamp fechaActualizacion;

}
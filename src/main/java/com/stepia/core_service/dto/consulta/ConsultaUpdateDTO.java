package com.stepia.core_service.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaUpdateDTO {

    @Positive
    private Long idProfesional;

    @Future
    private java.sql.Timestamp fechaHora;

    private String estado;

    @Size(max = 500)
    private String motivo;

    @Size(max = 1000)
    private String observaciones;
}
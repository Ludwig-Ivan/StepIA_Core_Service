package com.stepia.core_service.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ConsultaCreateDTO {

    @NotBlank
    @Size(min = 18, max = 18)
    private String idPaciente;

    @NotNull
    @Positive
    private Long idProfesional;

    @NotNull
    @Future
    private java.sql.Timestamp fechaHora;

    @Size(max = 500)
    private String motivo;

    @NotNull
    private String estado;

    @Size(max = 1000)
    private String observaciones;

    private Long idConsultaOrigen;

}

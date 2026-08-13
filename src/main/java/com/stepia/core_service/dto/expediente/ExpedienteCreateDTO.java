package com.stepia.core_service.dto.expediente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpedienteCreateDTO {

    @NotBlank(message = "El CURP del paciente es obligatorio")
    @Size(min = 18, max = 18, message = "El CURP debe tener 18 caracteres")
    private String idPaciente;

    @NotBlank(message = "El número de expediente es obligatorio")
    @Size(max = 30, message = "El número de expediente no puede superar los 30 caracteres")
    private String numeroExpediente;

    private String antecedentes;

    @NotBlank(message = "El estado del expediente es obligatorio")
    @Size(max = 20, message = "El estado del expediente no puede superar los 20 caracteres")
    private String estado;
}
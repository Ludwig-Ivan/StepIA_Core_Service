package com.stepia.core_service.dto.expediente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpedienteUpdateDTO {

    @NotBlank(message = "El número de expediente es obligatorio")
    @Size(max = 30, message = "El número de expediente no puede superar los 30 caracteres")
    private String numeroExpediente;

    private String antecedentes;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

}
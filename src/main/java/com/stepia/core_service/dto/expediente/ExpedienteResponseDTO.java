package com.stepia.core_service.dto.expediente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpedienteResponseDTO {

    private String idPaciente;
    private String numeroExpediente;
    private String antecedentes;
    private String estado;

}
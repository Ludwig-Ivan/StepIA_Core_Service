package com.stepia.core_service.dto.analisis;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalisisResponseDTO {
    private java.util.UUID idAnalisis;
    private java.util.UUID idInforme;
    private String pieType;
    private String className;
    private BigDecimal confidence;
    private java.sql.Timestamp fechaRegistro;
    private java.sql.Timestamp fechaActualizacion;
}

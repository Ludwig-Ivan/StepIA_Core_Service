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
public class AnalisisUpdateDTO {
    private java.util.UUID idInforme;
    private String pieType;
    private String className;
    private BigDecimal confidence;
}

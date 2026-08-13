package com.stepia.core_service.dto.informe;

import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformeResponseDTO {

    private UUID idInforme;

    private String idPaciente;

    private Long idProfesional;

    private String estadoGeneral;

    private BigDecimal pesoKg;

    private String sintomas;

    private String descripcion;

    private String diagnostico;

    private String codigoCie10;

    private String tratamiento;

    private String evolucion;

    private String observaciones;

    private OffsetDateTime fechaRegistro;
}
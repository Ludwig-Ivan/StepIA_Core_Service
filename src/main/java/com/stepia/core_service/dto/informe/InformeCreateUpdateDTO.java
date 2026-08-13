package com.stepia.core_service.dto.informe;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformeCreateUpdateDTO {
    @NotBlank(message = "El ID del paciente es obligatorio")
    @Size(min = 18, max = 18, message = "El CURP debe contener 18 caracteres")
    private String idPaciente;

    @NotNull(message = "El profesional es obligatorio")
    @Positive(message = "El ID del profesional debe ser positivo")
    private Long idProfesional;

    private String estadoGeneral;

    @DecimalMin(value = "0.01", message = "El peso debe ser mayor a 0")
    @DecimalMax(value = "500.00", message = "El peso no puede superar los 500 kg")
    private BigDecimal pesoKg;

    private String sintomas;

    private String descripcion;

    private String diagnostico;

    @Pattern(regexp = "^[A-Z][0-9]{2}(\\.[0-9A-Z]{1,4})?$", message = "El código CIE-10 no tiene un formato válido")
    private String codigoCie10;

    private String tratamiento;

    private String evolucion;

    private String observaciones;
}
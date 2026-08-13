package com.stepia.core_service.dto.pacientes;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacientesUpdateDTO {
    @NotBlank(message = "El campo 'nombre' no puede estar vacío")
    @Size(max = 100, message = "El campo 'nombre' no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "El campo 'apellidoPaterno' no puede estar vacío")
    @Size(max = 100, message = "El campo 'apellidoPaterno' no puede tener más de 100 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El campo 'apellidoMaterno' no puede estar vacío")
    @Size(max = 100, message = "El campo 'apellidoMaterno' no puede tener más de 100 caracteres")
    private String apellidoMaterno;

    @Past(message = "El campo 'fechaNacimiento' debe ser una fecha pasada")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El campo 'sexo' no puede estar vacío")
    @Size(max = 20, message = "El campo 'sexo' no puede tener más de 20 caracteres")
    private String sexo;

    @Size(max = 20, message = "El campo 'telefono' no puede tener más de 20 caracteres")
    private String telefono;

    @Size(max = 255, message = "El campo 'domicilio' no puede tener más de 255 caracteres")
    private String domicilio;
}

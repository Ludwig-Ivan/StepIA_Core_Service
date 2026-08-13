package com.stepia.core_service.dto.pacientes;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacientesCreateDTO {
    @NotBlank(message = "El campo curp es obligatorio")
    @Size(min = 18, max = 18, message = "El campo curp debe tener exactamente 18 caracteres")
    private String curp;

    @NotBlank(message = "El campo nombre es obligatorio")
    @Size(max = 100, message = "El campo nombre no debe exceder los 100 caracteres")
    private String nombre;

    @NotBlank(message = "El campo apellido paterno es obligatorio")
    @Size(max = 100, message = "El campo apellido paterno no debe exceder los 100 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El campo apellido materno es obligatorio")
    @Size(max = 100, message = "El campo apellido materno no debe exced er los 100 caracteres")
    private String apellidoMaterno;

    private LocalDate fechaNacimiento;

    @NotBlank(message = "El campo sexo es obligatorio")
    @Size(max = 20, message = "El campo sexo no debe exceder los 20 caracteres")
    private String sexo;

    @Size(max = 20, message = "El campo teléfono no debe exceder los 20 caracteres")
    private String telefono;

    @Size(max = 255, message = "El campo domicilio no debe exceder los 255 caracteres")
    private String domicilio;
}

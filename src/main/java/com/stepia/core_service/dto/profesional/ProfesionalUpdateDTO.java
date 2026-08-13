package com.stepia.core_service.dto.profesional;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesionalUpdateDTO {
    @NotBlank(message = "La especialidad es obligatoria")
    @Size(max = 150)
    private String especialidad;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 100)
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 100)
    private String apellidoMaterno;

    @Size(max = 20)
    private String cedulaProfesional;

    @Size(max = 20)
    private String cedulaEspecializada;

    @Size(max = 200)
    private String institucion;

    @Size(max = 20)
    private String telefono;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    @Size(max = 254)
    private String email;
}

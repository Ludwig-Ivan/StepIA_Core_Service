package com.stepia.core_service.dto.documento;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class DocumentoUpdateDTO {

    @NotBlank
    @Size(max = 18)
    private String idPaciente;

    @NotNull
    private Long idProfesional;

    private UUID idInforme;

    @NotBlank
    private String storageUri;

    @NotBlank
    @Size(max = 100)
    private String mimeType;

    @NotNull
    @Positive
    private Long tamanoBytes;

    @NotBlank
    @Pattern(regexp = "^[A-Fa-f0-9]{64}$", message = "El hash SHA-256 debe contener exactamente 64 caracteres hexadecimales")
    private String hashSha256;

    @NotNull
    @Min(1)
    private Integer version;

    @NotNull
    private java.sql.Timestamp fechaDocumento;

    private String descripcion;
}
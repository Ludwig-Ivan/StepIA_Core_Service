package com.stepia.core_service.dto.documento;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class DocumentoUpdateDTO {

    @Size(max = 18)
    private String idPaciente;

    private Long idProfesional;

    private UUID idInforme;

    private UUID idAnalisis;

    private String storageUri;

    @Size(max = 100)
    private String storageKey;

    private String nombreDocumento;

    private String mimeType;

    @Positive
    private Long tamanoBytes;

    @Pattern(regexp = "^[A-Fa-f0-9]{64}$", message = "El hash SHA-256 debe contener exactamente 64 caracteres hexadecimales")
    private String hashSha256;

    @Min(1)
    private Integer version;

    private java.sql.Timestamp fechaDocumento;
}
package com.stepia.core_service.dto.documento;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoResponseDTO {

    private UUID idDocumento;

    private String idPaciente;

    private Long idProfesional;

    private UUID idInforme;

    private UUID idAnalisis;

    private String storageUri;

    private String storageKey;

    private String nombreDocumento;

    private String mimeType;

    private Long tamanoBytes;

    private String hashSha256;

    private Integer version;

    private java.sql.Timestamp fechaDocumento;

}
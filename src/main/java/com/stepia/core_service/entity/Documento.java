package com.stepia.core_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "documentos_clinicos", schema = "documentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_documento", nullable = false, updatable = false)
    private UUID idDocumento;

    @Column(name = "id_paciente", columnDefinition = "bpchar", nullable = false, length = 18)
    private String idPaciente;

    @Column(name = "id_profesional", columnDefinition = "bigint", nullable = false)
    private Long idProfesional;

    @Column(name = "id_informe", columnDefinition = "uuid")
    private UUID idInforme;

    @Column(name = "storage_uri", nullable = false, columnDefinition = "TEXT")
    private String storageUri;

    @Column(name = "mime_type", nullable = false, length = 100)
    private String mimeType;

    @Column(name = "tamano_bytes", nullable = false)
    private Long tamanoBytes;

    @Column(name = "hash_sha256", columnDefinition = "bpchar", nullable = false, length = 64)
    private String hashSha256;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "fecha_documento", nullable = false)
    private java.sql.Timestamp fechaDocumento;

    @CreationTimestamp
    @Column(name = "fecha_carga", nullable = false)
    private java.sql.Timestamp fechaCarga;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
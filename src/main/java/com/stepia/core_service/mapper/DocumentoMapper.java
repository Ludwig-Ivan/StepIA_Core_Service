package com.stepia.core_service.mapper;

import com.stepia.core_service.dto.documento.*;
import com.stepia.core_service.entity.Documento;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper {

    public Documento toEntity(
            DocumentoCreateDTO dto) {

        Documento entity = new Documento();

        entity.setIdPaciente(dto.getIdPaciente());
        entity.setIdProfesional(dto.getIdProfesional());
        entity.setIdInforme(dto.getIdInforme());
        entity.setStorageUri(dto.getStorageUri());
        entity.setMimeType(dto.getMimeType());
        entity.setTamanoBytes(dto.getTamanoBytes());
        entity.setHashSha256(dto.getHashSha256());
        entity.setVersion(dto.getVersion());
        entity.setFechaDocumento(dto.getFechaDocumento());
        entity.setDescripcion(dto.getDescripcion());

        return entity;
    }

    public void updateEntity(
            Documento entity,
            DocumentoUpdateDTO dto) {

        entity.setIdPaciente(dto.getIdPaciente());
        entity.setIdProfesional(dto.getIdProfesional());
        entity.setIdInforme(dto.getIdInforme());
        entity.setStorageUri(dto.getStorageUri());
        entity.setMimeType(dto.getMimeType());
        entity.setTamanoBytes(dto.getTamanoBytes());
        entity.setHashSha256(dto.getHashSha256());
        entity.setVersion(dto.getVersion());
        entity.setFechaDocumento(dto.getFechaDocumento());
        entity.setDescripcion(dto.getDescripcion());
    }

    public DocumentoResponseDTO toResponse(
            Documento entity) {

        DocumentoResponseDTO dto = new DocumentoResponseDTO();

        dto.setIdDocumento(entity.getIdDocumento());
        dto.setIdPaciente(entity.getIdPaciente());
        dto.setIdProfesional(entity.getIdProfesional());
        dto.setIdInforme(entity.getIdInforme());
        dto.setStorageUri(entity.getStorageUri());
        dto.setMimeType(entity.getMimeType());
        dto.setTamanoBytes(entity.getTamanoBytes());
        dto.setHashSha256(entity.getHashSha256());
        dto.setVersion(entity.getVersion());
        dto.setFechaDocumento(entity.getFechaDocumento());
        dto.setDescripcion(entity.getDescripcion());

        return dto;
    }
}
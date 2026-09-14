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
        entity.setIdAnalisis(dto.getIdAnalisis());
        entity.setStorageUri(dto.getStorageUri());
        entity.setStorageKey(dto.getStorageKey());
        entity.setNombreDocumento(dto.getNombreDocumento());
        entity.setMimeType(dto.getMimeType());
        entity.setTamanoBytes(dto.getTamanoBytes());
        entity.setHashSha256(dto.getHashSha256());
        entity.setVersion(dto.getVersion());
        entity.setFechaDocumento(dto.getFechaDocumento());

        return entity;
    }

    public void updateEntity(
            Documento entity,
            DocumentoUpdateDTO dto) {

        entity.setIdPaciente(dto.getIdPaciente());
        entity.setIdProfesional(dto.getIdProfesional());
        entity.setIdInforme(dto.getIdInforme());
        entity.setIdAnalisis(dto.getIdAnalisis());
        entity.setStorageUri(dto.getStorageUri());
        entity.setStorageKey(dto.getStorageKey());
        entity.setNombreDocumento(dto.getNombreDocumento());
        entity.setMimeType(dto.getMimeType());
        entity.setTamanoBytes(dto.getTamanoBytes());
        entity.setHashSha256(dto.getHashSha256());
        entity.setVersion(dto.getVersion());
        entity.setFechaDocumento(dto.getFechaDocumento());
    }

    public DocumentoResponseDTO toResponse(
            Documento entity) {

        DocumentoResponseDTO dto = new DocumentoResponseDTO();

        dto.setIdDocumento(entity.getIdDocumento());
        dto.setIdPaciente(entity.getIdPaciente());
        dto.setIdProfesional(entity.getIdProfesional());
        dto.setIdInforme(entity.getIdInforme());
        dto.setIdAnalisis(entity.getIdAnalisis());
        dto.setStorageUri(entity.getStorageUri());
        dto.setStorageKey(entity.getStorageKey());
        dto.setNombreDocumento(entity.getNombreDocumento());
        dto.setMimeType(entity.getMimeType());
        dto.setTamanoBytes(entity.getTamanoBytes());
        dto.setHashSha256(entity.getHashSha256());
        dto.setVersion(entity.getVersion());
        dto.setFechaDocumento(entity.getFechaDocumento());

        return dto;
    }
}
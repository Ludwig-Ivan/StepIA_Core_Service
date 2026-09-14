package com.stepia.core_service.repository;

import com.stepia.core_service.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface DocumentoRepository
        extends JpaRepository<Documento, UUID> {

    List<Documento> findByIdPaciente(String idPaciente);

    List<Documento> findByIdProfesional(Long idProfesional);

    List<Documento> findByIdInforme(UUID idInforme);

    List<Documento> findByStorageKey(String storageKey);
}
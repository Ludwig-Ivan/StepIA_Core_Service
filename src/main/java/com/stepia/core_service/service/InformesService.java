package com.stepia.core_service.service;

import com.stepia.core_service.dto.informe.InformeCreateUpdateDTO;
import com.stepia.core_service.dto.informe.InformeResponseDTO;
import com.stepia.core_service.entity.Informe;
import com.stepia.core_service.mapper.InformeMapper;
import com.stepia.core_service.repository.InformeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InformesService {

    private final InformeRepository repository;
    private final InformeMapper mapper;

    public InformesService(
            InformeRepository repository,
            InformeMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    // =====================================================
    // CREATE
    // =====================================================

    public InformeResponseDTO create(
            InformeCreateUpdateDTO request) {

        Informe entity = mapper.toEntity(request);

        Informe saved = repository.save(entity);

        return mapper.toResponse(saved);
    }

    // =====================================================
    // READ ALL
    // =====================================================

    @Transactional(readOnly = true)
    public List<InformeResponseDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // =====================================================
    // READ BY ID
    // =====================================================

    @Transactional(readOnly = true)
    public InformeResponseDTO findById(UUID id) {

        Informe entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Informe no encontrado: " + id));

        return mapper.toResponse(entity);
    }

    // =====================================================
    // READ BY PACIENTE
    // =====================================================

    @Transactional(readOnly = true)
    public List<InformeResponseDTO> findByPaciente(
            String idPaciente) {

        return repository.findByIdPaciente(idPaciente)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // =====================================================
    // READ BY PROFESIONAL
    // =====================================================

    @Transactional(readOnly = true)
    public List<InformeResponseDTO> findByProfesional(
            Long idProfesional) {

        return repository.findByIdProfesional(idProfesional)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // =====================================================
    // UPDATE
    // =====================================================

    public InformeResponseDTO update(
            UUID id,
            InformeCreateUpdateDTO request) {

        Informe entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Informe no encontrado: " + id));

        mapper.updateEntity(entity, request);

        Informe updated = repository.save(entity);

        return mapper.toResponse(updated);
    }
}
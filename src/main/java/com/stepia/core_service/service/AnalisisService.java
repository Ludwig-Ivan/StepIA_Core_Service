package com.stepia.core_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stepia.core_service.dto.analisis.AnalisisCreateDTO;
import com.stepia.core_service.dto.analisis.AnalisisResponseDTO;
import com.stepia.core_service.dto.analisis.AnalisisUpdateDTO;
import com.stepia.core_service.entity.Analisis;
import com.stepia.core_service.mapper.AnalisisMapper;
import com.stepia.core_service.repository.AnalisisRepository;

@Service
@Transactional
public class AnalisisService {
    private final AnalisisRepository repository;
    private final AnalisisMapper mapper;

    public AnalisisService(AnalisisRepository repository, AnalisisMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AnalisisResponseDTO create(AnalisisCreateDTO request) {
        Analisis entity = mapper.toEntity(request);
        Analisis saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public AnalisisResponseDTO findByIdAnalisis(UUID id) {
        Analisis entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Analisis no encontrado: " + id));
        return mapper.toResponse(entity);
    }

    @Transactional(readOnly = true)
    public List<AnalisisResponseDTO> findByIdInforme(UUID id) {
        return repository.findByIdInforme(id).stream().map(mapper::toResponse).toList();
    }

    public AnalisisResponseDTO update(UUID id, AnalisisUpdateDTO request) {
        Analisis entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Analisis no encontrado: " + id));
        mapper.updateEntity(entity, request);
        Analisis updated = repository.save(entity);
        return mapper.toResponse(updated);
    }
}

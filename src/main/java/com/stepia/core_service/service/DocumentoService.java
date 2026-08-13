package com.stepia.core_service.service;

import com.stepia.core_service.dto.documento.*;
import com.stepia.core_service.entity.Documento;
import com.stepia.core_service.mapper.DocumentoMapper;
import com.stepia.core_service.repository.DocumentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DocumentoService {

        private final DocumentoRepository repository;
        private final DocumentoMapper mapper;

        public DocumentoService(
                        DocumentoRepository repository,
                        DocumentoMapper mapper) {
                this.repository = repository;
                this.mapper = mapper;
        }

        public DocumentoResponseDTO crear(
                        DocumentoCreateDTO dto) {

                Documento entity = mapper.toEntity(dto);

                Documento guardado = repository.save(entity);

                return mapper.toResponse(guardado);
        }

        @Transactional(readOnly = true)
        public List<DocumentoResponseDTO> obtenerTodos() {

                return repository.findAll()
                                .stream()
                                .map(mapper::toResponse)
                                .toList();
        }

        @Transactional(readOnly = true)
        public DocumentoResponseDTO obtenerPorId(
                        UUID id) {

                Documento entity = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Documento no encontrado: " + id));

                return mapper.toResponse(entity);
        }

        @Transactional(readOnly = true)
        public List<DocumentoResponseDTO> obtenerPorPaciente(
                        String idPaciente) {

                return repository
                                .findByIdPaciente(idPaciente)
                                .stream()
                                .map(mapper::toResponse)
                                .toList();
        }

        @Transactional(readOnly = true)
        public List<DocumentoResponseDTO> obtenerPorProfesional(
                        Long idProfesional) {

                return repository
                                .findByIdProfesional(idProfesional)
                                .stream()
                                .map(mapper::toResponse)
                                .toList();
        }

        @Transactional(readOnly = true)
        public List<DocumentoResponseDTO> obtenerPorInforme(
                        UUID idInforme) {

                return repository
                                .findByIdInforme(idInforme)
                                .stream()
                                .map(mapper::toResponse)
                                .toList();
        }

        public DocumentoResponseDTO actualizar(
                        UUID id,
                        DocumentoUpdateDTO dto) {

                Documento entity = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Documento no encontrado: " + id));

                mapper.updateEntity(entity, dto);

                Documento actualizado = repository.save(entity);

                return mapper.toResponse(actualizado);
        }
}
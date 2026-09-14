package com.stepia.core_service.service;

import com.stepia.core_service.dto.profesional.ProfesionalCreateDTO;
import com.stepia.core_service.dto.profesional.ProfesionalResponseDTO;
import com.stepia.core_service.dto.profesional.ProfesionalUpdateDTO;
import com.stepia.core_service.entity.Profesional;
import com.stepia.core_service.mapper.ProfesionalMapper;
import com.stepia.core_service.repository.ProfesionalRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfesionalService {

        private final ProfesionalRepository profesionalRepository;
        private final ProfesionalMapper profesionalMapper;

        public ProfesionalService(
                        ProfesionalRepository profesionalRepository,
                        ProfesionalMapper profesionalMapper) {
                this.profesionalRepository = profesionalRepository;
                this.profesionalMapper = profesionalMapper;
        }

        public ProfesionalResponseDTO create(
                        ProfesionalCreateDTO dto) {

                validarUnicidad(
                                dto.getEmail(),
                                dto.getCedulaProfesional(),
                                dto.getCedulaEspecializada(),
                                null);

                Profesional profesional = profesionalMapper.toEntity(dto);

                profesional = profesionalRepository.save(profesional);

                return profesionalMapper.toResponseDTO(profesional);
        }

        // =========================================================
        // READ ALL
        // =========================================================

        @Transactional(readOnly = true)
        public List<ProfesionalResponseDTO> findAll() {

                return profesionalRepository
                                .findAll()
                                .stream()
                                .map(profesionalMapper::toResponseDTO)
                                .toList();
        }

        // =========================================================
        // READ ACTIVE
        // =========================================================

        @Transactional(readOnly = true)
        public List<ProfesionalResponseDTO> findAllActivos() {

                return profesionalRepository
                                .findByActivoTrue()
                                .stream()
                                .map(profesionalMapper::toResponseDTO)
                                .toList();
        }

        // =========================================================
        // READ BY ID
        // =========================================================

        @Transactional(readOnly = true)
        public ProfesionalResponseDTO findById(
                        Long id) {

                Profesional profesional = obtenerProfesional(id);

                return profesionalMapper.toResponseDTO(profesional);
        }

        @Transactional(readOnly = true)
        public ProfesionalResponseDTO findByEmail(String email) {
                Profesional profesional = obteneProfesionalByEmail(email);
                return profesionalMapper.toResponseDTO(profesional);
        }

        // =========================================================
        // UPDATE
        // =========================================================

        public ProfesionalResponseDTO update(
                        Long id,
                        ProfesionalUpdateDTO dto) {

                Profesional profesional = obtenerProfesional(id);

                validarUnicidad(
                                dto.getEmail(),
                                dto.getCedulaProfesional(),
                                dto.getCedulaEspecializada(),
                                id);

                profesionalMapper.updateEntity(
                                profesional,
                                dto);

                profesional = profesionalRepository.save(profesional);

                return profesionalMapper.toResponseDTO(profesional);
        }

        // =========================================================
        // DELETE / DESACTIVAR
        // =========================================================

        public void delete(Long id) {

                Profesional profesional = obtenerProfesional(id);

                profesional.setActivo(false);

                profesionalRepository.save(profesional);
        }

        // =========================================================
        // REACTIVAR
        // =========================================================

        public ProfesionalResponseDTO reactivar(
                        Long id) {

                Profesional profesional = obtenerProfesional(id);

                profesional.setActivo(true);

                profesional = profesionalRepository.save(profesional);

                return profesionalMapper.toResponseDTO(profesional);
        }

        // =========================================================
        // MÉTODOS PRIVADOS
        // =========================================================

        private Profesional obtenerProfesional(Long id) {

                return profesionalRepository
                                .findById(id)
                                .orElseThrow(() -> new EntityNotFoundException(
                                                "No existe el profesional con ID: " + id));
        }

        private Profesional obteneProfesionalByEmail(String email) {
                return profesionalRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(
                                "No existe el profesional con email: " + email));
        }

        private void validarUnicidad(
                        String email,
                        String cedulaProfesional,
                        String cedulaEspecializada,
                        Long idActual) {

                profesionalRepository
                                .findByEmail(email)
                                .ifPresent(profesional -> {

                                        if (!profesional.getIdProfesional()
                                                        .equals(idActual)) {

                                                throw new IllegalArgumentException(
                                                                "El correo electrónico ya está registrado");
                                        }
                                });

                profesionalRepository
                                .findByCedulaProfesional(cedulaProfesional)
                                .ifPresent(profesional -> {

                                        if (!profesional.getIdProfesional()
                                                        .equals(idActual)) {

                                                throw new IllegalArgumentException(
                                                                "La cédula profesional ya está registrada");
                                        }
                                });

                if (cedulaEspecializada != null &&
                                !cedulaEspecializada.isBlank()) {

                        profesionalRepository
                                        .findByCedulaEspecializada(
                                                        cedulaEspecializada)
                                        .ifPresent(profesional -> {

                                                if (!profesional.getIdProfesional()
                                                                .equals(idActual)) {

                                                        throw new IllegalArgumentException(
                                                                        "La cédula especializada ya está registrada");
                                                }
                                        });
                }
        }
}
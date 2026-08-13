package com.stepia.core_service.controller;

import com.stepia.core_service.dto.informe.InformeCreateUpdateDTO;
import com.stepia.core_service.dto.informe.InformeResponseDTO;
import com.stepia.core_service.service.InformesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/informes")
public class InformesController {

        private final InformesService service;

        public InformesController(
                        InformesService service) {

                this.service = service;
        }

        // =====================================================
        // CREATE
        // =====================================================

        @PostMapping
        public ResponseEntity<InformeResponseDTO> create(
                        @Valid @RequestBody InformeCreateUpdateDTO request) {

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(service.create(request));
        }

        // =====================================================
        // READ ALL
        // =====================================================

        @GetMapping
        public ResponseEntity<List<InformeResponseDTO>> findAll() {

                return ResponseEntity.ok(
                                service.findAll());
        }

        // =====================================================
        // READ BY ID
        // =====================================================

        @GetMapping("/{id}")
        public ResponseEntity<InformeResponseDTO> findById(
                        @PathVariable UUID id) {

                return ResponseEntity.ok(
                                service.findById(id));
        }

        // =====================================================
        // READ BY PACIENTE
        // =====================================================

        @GetMapping("/paciente/{idPaciente}")
        public ResponseEntity<List<InformeResponseDTO>> findByPaciente(
                        @PathVariable String idPaciente) {

                return ResponseEntity.ok(
                                service.findByPaciente(idPaciente));
        }

        // =====================================================
        // READ BY PROFESIONAL
        // =====================================================

        @GetMapping("/profesional/{idProfesional}")
        public ResponseEntity<List<InformeResponseDTO>> findByProfesional(
                        @PathVariable Long idProfesional) {

                return ResponseEntity.ok(
                                service.findByProfesional(idProfesional));
        }

        // =====================================================
        // UPDATE
        // =====================================================

        @PutMapping("/{id}")
        public ResponseEntity<InformeResponseDTO> update(
                        @PathVariable UUID id,
                        @Valid @RequestBody InformeCreateUpdateDTO request) {

                return ResponseEntity.ok(
                                service.update(id, request));
        }
}
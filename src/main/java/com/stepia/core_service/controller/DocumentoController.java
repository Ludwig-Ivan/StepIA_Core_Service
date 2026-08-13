package com.stepia.core_service.controller;

import com.stepia.core_service.dto.documento.*;
import com.stepia.core_service.service.DocumentoService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

        private final DocumentoService service;

        public DocumentoController(
                        DocumentoService service) {
                this.service = service;
        }

        // ==========================================
        // POST
        // ==========================================

        @PostMapping
        public ResponseEntity<DocumentoResponseDTO> crear(
                        @Valid @RequestBody DocumentoCreateDTO dto) {

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(service.crear(dto));
        }

        // ==========================================
        // GET ALL
        // ==========================================

        @GetMapping
        public ResponseEntity<List<DocumentoResponseDTO>> obtenerTodos() {

                return ResponseEntity.ok(
                                service.obtenerTodos());
        }

        // ==========================================
        // GET BY ID
        // ==========================================

        @GetMapping("/{id}")
        public ResponseEntity<DocumentoResponseDTO> obtenerPorId(
                        @PathVariable UUID id) {

                return ResponseEntity.ok(
                                service.obtenerPorId(id));
        }

        // ==========================================
        // GET BY PACIENTE
        // ==========================================

        @GetMapping("/paciente/{idPaciente}")
        public ResponseEntity<List<DocumentoResponseDTO>> obtenerPorPaciente(
                        @PathVariable String idPaciente) {

                return ResponseEntity.ok(
                                service.obtenerPorPaciente(idPaciente));
        }

        // ==========================================
        // GET BY PROFESIONAL
        // ==========================================

        @GetMapping("/profesional/{idProfesional}")
        public ResponseEntity<List<DocumentoResponseDTO>> obtenerPorProfesional(
                        @PathVariable Long idProfesional) {

                return ResponseEntity.ok(
                                service.obtenerPorProfesional(idProfesional));
        }

        // ==========================================
        // GET BY INFORME
        // ==========================================

        @GetMapping("/informe/{idInforme}")
        public ResponseEntity<List<DocumentoResponseDTO>> obtenerPorInforme(
                        @PathVariable UUID idInforme) {

                return ResponseEntity.ok(
                                service.obtenerPorInforme(idInforme));
        }

        // ==========================================
        // PUT
        // ==========================================

        @PutMapping("/{id}")
        public ResponseEntity<DocumentoResponseDTO> actualizar(
                        @PathVariable UUID id,
                        @Valid @RequestBody DocumentoUpdateDTO dto) {

                return ResponseEntity.ok(
                                service.actualizar(id, dto));
        }
}
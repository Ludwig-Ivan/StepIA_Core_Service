package com.stepia.core_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stepia.core_service.dto.consulta.ConsultaCreateDTO;
import com.stepia.core_service.dto.consulta.ConsultaResponseDTO;
import com.stepia.core_service.dto.consulta.ConsultaUpdateDTO;
import com.stepia.core_service.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

        private final ConsultaService service;

        public ConsultaController(ConsultaService service) {
                this.service = service;
        }

        @PostMapping
        public ResponseEntity<ConsultaResponseDTO> crear(
                        @Valid @RequestBody ConsultaCreateDTO dto) {

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(service.crearConsulta(dto));
        }

        @GetMapping("/{id}")
        public ResponseEntity<ConsultaResponseDTO> obtenerPorId(
                        @PathVariable Long id) {

                return ResponseEntity.ok(
                                service.obtenerPorId(id));
        }

        @GetMapping("/paciente/{curp}")
        public ResponseEntity<List<ConsultaResponseDTO>> obtenerPorPaciente(
                        @PathVariable String curp) {

                return ResponseEntity.ok(
                                service.obtenerPorPaciente(curp));
        }

        @PatchMapping("/{id}")
        public ResponseEntity<ConsultaResponseDTO> actualizar(
                        @PathVariable Long id,
                        @Valid @RequestBody ConsultaUpdateDTO dto) {

                return ResponseEntity.ok(
                                service.actualizarConsulta(id, dto));
        }

        @PatchMapping("/{id}/estado")
        public ResponseEntity<ConsultaResponseDTO> cambiarEstado(
                        @PathVariable Long id,
                        @RequestParam String estado) {

                return ResponseEntity.ok(
                                service.cambiarEstado(id, estado));
        }
}

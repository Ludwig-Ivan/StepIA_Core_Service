package com.stepia.core_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.stepia.core_service.entity.Pacientes;

public interface PacientesRepository extends JpaRepository<Pacientes, String> {
    Page<Pacientes> findByNombreContainingIgnoreCaseOrApellidoPaternoContainingIgnoreCaseOrApellidoMaternoContainingIgnoreCaseOrCurpContaining(
            String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String Curp,
            Pageable pageable);
}

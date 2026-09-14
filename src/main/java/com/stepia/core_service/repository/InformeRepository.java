package com.stepia.core_service.repository;

import com.stepia.core_service.entity.Informe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface InformeRepository
                extends JpaRepository<Informe, UUID> {

        Page<Informe> findByIdPaciente(String idPaciente, Pageable pageable);

        List<Informe> findByIdProfesional(Long idProfesional);

        List<Informe> findByIdPacienteAndIdProfesional(
                        String idPaciente,
                        Long idProfesional);
}
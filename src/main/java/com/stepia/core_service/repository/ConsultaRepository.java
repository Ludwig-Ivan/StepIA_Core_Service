package com.stepia.core_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stepia.core_service.entity.Consulta;

import java.util.List;

public interface ConsultaRepository
                extends JpaRepository<Consulta, Long> {

        List<Consulta> findByIdPaciente(String idPaciente);

        List<Consulta> findByIdProfesional(Long idProfesional);;

        List<Consulta> findByEstado(String estado);

        List<Consulta> findByIdPacienteAndEstado(
                        String curp,
                        String estado);
}
package com.stepia.core_service.repository;

import com.stepia.core_service.entity.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpedienteRepository
                extends JpaRepository<Expediente, String> {

        Optional<Expediente> findByNumeroExpediente(
                        String numeroExpediente);

        boolean existsByNumeroExpediente(
                        String numeroExpediente);
}

package com.br.star.repository;

import com.br.star.domain.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
    Optional<Planeta> findByNome(String nome);
    boolean existsByNome(String nome);
}

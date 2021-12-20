package com.onnovacion.banco.repository;

import com.onnovacion.banco.entity.PersonaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJuridicaRepository extends JpaRepository<PersonaJuridica, Integer> {
}

package com.onnovacion.banco.repository;

import com.onnovacion.banco.entity.PersonaNatural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaNaturalRepository extends JpaRepository<PersonaNatural, Integer> {
}

package com.prova.topicos.repositories;

import com.prova.topicos.entities.Emprego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoRepository extends JpaRepository<Emprego, Long> {
}

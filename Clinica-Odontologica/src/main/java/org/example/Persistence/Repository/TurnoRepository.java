package org.example.Persistence.Repository;

import org.example.Persistence.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}

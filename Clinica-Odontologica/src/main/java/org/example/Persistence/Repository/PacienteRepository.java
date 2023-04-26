package org.example.Persistence.Repository;

import org.example.Persistence.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Paciente p WHERE p.nombre = :nombre AND p.apellido = :apellido")
    boolean existsByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}

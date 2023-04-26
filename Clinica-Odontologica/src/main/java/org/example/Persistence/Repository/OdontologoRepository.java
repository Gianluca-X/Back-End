package org.example.Persistence.Repository;

import org.example.Persistence.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Odontologo o WHERE o.nombre = :nombre AND o.apellido = :apellido")
    boolean existsByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}

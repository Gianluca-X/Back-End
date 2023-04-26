package org.example.Service;

import org.apache.log4j.Logger;
import org.example.Persistence.Entity.Turno;
import org.example.Persistence.Repository.TurnoRepository;
import org.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
   private final Logger log  = Logger.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public List<Turno> listar()throws ResourceNotFoundException{
        if(turnoRepository.findAll().isEmpty()){
            log.error("No existen turnos aun");
            throw new ResourceNotFoundException("No existen turnos aun");
        }
        return turnoRepository.findAll();
    }
    public void eliminar(Integer id)throws ResourceNotFoundException{
        if(turnoRepository.findById(id).isEmpty()){
            log.error("No existen turnos con ese id " + id);
            throw new ResourceNotFoundException("No existen turnos con ese id " + id);
        }
        log.info("Turno encontrado");
        turnoRepository.deleteById(id);

    }
    public Turno actualizar(Turno turno)throws ResourceNotFoundException{
        if(turnoRepository.findById(turno.getId()).isEmpty()){
            log.error("No existen turnos con ese id " + turno.getId());
            throw new ResourceNotFoundException("No existen turnos con ese id " + turno.getId());
        }
        log.info("Turno encontrado");
        return turnoRepository.save(turno);
    }
    public Optional<Turno> buscar(Integer id)throws ResourceNotFoundException{
        if(turnoRepository.findById(id).isEmpty()){
            log.error("No existen turnos con ese id " + id);
            throw new ResourceNotFoundException("No existen turnos con ese id " + id);
        }
        log.info("Turno encontrado");
      return turnoRepository.findById(id);
    }

}

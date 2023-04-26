package org.example.Service;
import org.apache.log4j.Logger;

import org.example.Persistence.Entity.Paciente;
import org.example.Persistence.Repository.PacienteRepository;
import org.example.exception.PacienteExistenteException;
import org.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final Logger log = Logger.getLogger(PacienteService.class);

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) throws PacienteExistenteException {
        if (pacienteRepository.existsByNombreAndApellido(p.getNombre(), p.getApellido())) {
            throw new PacienteExistenteException("Ya existe un paciente con el mismo nombre y apellido");
        }
     return pacienteRepository.save(p);

    }

    public Optional<Paciente> buscar(Integer id) throws ResourceNotFoundException {

           if(pacienteRepository.findById(id).isEmpty()){
               log.error("No existen pacientes con ese id " + id);
           throw new ResourceNotFoundException("No existen pacientes con ese id " + id);
        }   log.info("Paciente encontrado");

        return pacienteRepository.findById(id);
    }

    public List<Paciente> buscarTodos()throws ResourceNotFoundException {
        if(pacienteRepository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No existen pacientes aun");
        }
        log.info("Buscando lista");
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (this.buscar(id).isPresent()) {
            log.info("Paciente eliminado");
            pacienteRepository.deleteById(id);
        }

    }

    public Paciente actualizar(Paciente p)throws ResourceNotFoundException {
        if (this.buscar(p.getId()).isPresent()) {
            log.info("Actualizando paciente");
            return pacienteRepository.save(p);
        }
        return null;
    }
}

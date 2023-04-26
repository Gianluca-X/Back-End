package org.example.Service;

import org.apache.log4j.Logger;
import org.example.Persistence.Entity.Odontologo;
import org.example.Persistence.Repository.OdontologoRepository;
import org.example.exception.OdontologoExistenteException;
import org.example.exception.PacienteExistenteException;
import org.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private final Logger log = Logger.getLogger(OdontologoService.class);
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) throws OdontologoExistenteException {
        if (odontologoRepository.existsByNombreAndApellido(odontologo.getNombre(), odontologo.getApellido())) {
            throw new OdontologoExistenteException("Ya existe un odontologo con el mismo nombre y apellido");
        }
        log.info("Odontologo guardando");

        return odontologoRepository.save(odontologo);

    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        if(this.buscar(id).isPresent()){
            log.info("Odontologo encontrado");
            odontologoRepository.deleteById(id);
        }

    }

    public Optional<Odontologo> buscar(Integer id) throws ResourceNotFoundException{
        if(odontologoRepository.findById(id).isEmpty()){
            log.error("No existen odontologos con ese id " + id);
            throw new ResourceNotFoundException("No existen odontologos con ese id " + id);
        }
        log.info("Odontologo encontrado");
        return odontologoRepository.findById(id);
    }

    public List<Odontologo> buscarTodos() throws ResourceNotFoundException{
        if(odontologoRepository.findAll().isEmpty()){
            log.error("No existen odontologos aun");
            throw new ResourceNotFoundException("No existen odontologos aun");
        }
        log.info("Odontologos encontrados");
        return odontologoRepository.findAll();
    }

    public Odontologo actualizar(Odontologo odontologo) throws ResourceNotFoundException{
        if(this.buscar(odontologo.getId()).isPresent()) {
            log.info("Odontologo actualizado");
            return odontologoRepository.save(odontologo);
        }
        return null;
    }
}
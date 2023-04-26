package org.example.Controller;

import org.example.Persistence.Entity.Turno;
import org.example.Service.OdontologoService;
import org.example.Service.PacienteService;
import org.example.Service.TurnoService;
import org.apache.log4j.Logger;

import org.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private static final Logger log = Logger.getLogger(TurnoController.class);

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        log.info("Metodo POST - Creando turno");
        ResponseEntity<Turno> response;
        if (pacienteService.buscar(turno.getPaciente().getId()).isPresent() && odontologoService.buscar(turno.getOdontologo().getId()).isPresent())
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;


    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() throws ResourceNotFoundException {
        log.info("GET metodo --- Mostrando turnos");
        return ResponseEntity.ok(turnoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException{
        ResponseEntity<String> response;
        log.info("Metodo DELETE - eliminando"+id);
        if (turnoService.buscar(id).isPresent()) {
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno)throws ResourceNotFoundException {
        log.info("Metodo PUT - actualizando turno");
        return ResponseEntity.ok(turnoService.actualizar(turno));

    }


}

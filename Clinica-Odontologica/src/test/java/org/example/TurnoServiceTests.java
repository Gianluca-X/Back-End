package org.example;

import org.example.Persistence.Entity.Domicilio;
import org.example.Persistence.Entity.Odontologo;
import org.example.Persistence.Entity.Paciente;
import org.example.Persistence.Entity.Turno;
import org.example.Service.OdontologoService;
import org.example.Service.PacienteService;
import org.example.Service.TurnoService;
import org.example.exception.OdontologoExistenteException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.example.util.Jsons;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet()  {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        this.odontologoService.registrarOdontologo(new Odontologo("Santiago", "Paz", 3455647));
    }
    @Test
    public void altaTurnoTest()  {
        this.cargarDataSet();
        turnoService.registrarTurno(new Turno(pacienteService.buscar(1).get(),odontologoService.buscar(1).get(),new Date()));
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void eliminarTurnoTest(){
        turnoService.eliminar(1);
        Assert.assertFalse(turnoService.buscar(1).isPresent());
    }
}

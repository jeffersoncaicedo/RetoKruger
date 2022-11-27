package com.retokruger.RetoKruger.service;

import com.retokruger.RetoKruger.lists.EstadoVacunaEmpleado;
import com.retokruger.RetoKruger.lists.LaboratorioVacuna;
import com.retokruger.RetoKruger.model.Empleados;
import com.retokruger.RetoKruger.model.Vacuna;
import com.retokruger.RetoKruger.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import springfox.documentation.schema.Example;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    //@Autowired
    //private Vacuna vacuna;

    public Empleados create(Empleados empleados){
        return empleadoRepository.save(empleados);
    }

    public List<Empleados> getAllEmployes(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleados> findEmploye (Long id_empleado){
        return empleadoRepository.findById(id_empleado);
    }

    public void delete (Empleados empleados){
        empleadoRepository.delete(empleados);
    }


    public Empleados update(Empleados empleados){
        return  empleadoRepository.saveAndFlush(empleados);
    }

}

package com.retokruger.RetoKruger.rest;

import com.retokruger.RetoKruger.model.Empleados;
import com.retokruger.RetoKruger.service.EmpleadoService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class EmpleadoREST {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(value = "/")
    private ResponseEntity<List<Empleados>> getAllEmployes(){
        return ResponseEntity.ok(empleadoService.getAllEmployes());
    }

    @GetMapping(value = "/{id_empleado}")
    private ResponseEntity<Optional<Empleados>> getEmployeforID(@PathVariable("id_empleado") Long id_empleado){
        return ResponseEntity.ok(empleadoService.findEmploye(id_empleado));
    }

    @PostMapping
    private ResponseEntity<Empleados> addEmploye(@RequestBody Empleados empleados){
        Empleados temporal = empleadoService.create(empleados);

        try{
            return ResponseEntity.created(new URI("api/admin" + temporal.getId_empleado())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteEmploye(@RequestBody Empleados empleados){
        empleadoService.delete(empleados);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/{id_elpleado}")
    @Transactional
    private ResponseEntity<Empleados> updateEmploye(@PathParam("id_empleado") Long id_empleado){
        Optional<Empleados> idtemp = empleadoService.findEmploye(id_empleado);

        Empleados temporal =  idtemp.orElse(null);

        try{
            return ResponseEntity.created(URI.create("api/admin" + temporal.getId_empleado())).body(temporal);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

package com.retokruger.RetoKruger.rest;

import com.retokruger.RetoKruger.model.Empleados;
import com.retokruger.RetoKruger.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserREST {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(value = "/{id_empleado}")
    private ResponseEntity<Optional<Empleados>> getEmployeforID(@PathVariable("id_empleado") Long id_empleado){
        return ResponseEntity.ok(empleadoService.findEmploye(id_empleado));
    }
}

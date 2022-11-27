package com.retokruger.RetoKruger.repository;

import com.retokruger.RetoKruger.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {
}

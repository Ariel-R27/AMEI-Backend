package com.amei.amei.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amei.amei.department.entity.Departamento;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.utils.Estado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
     // Método personalizado para encontrar empleados activos de un departamento
    List<Empleado> findByDepartamentoAndEstado(Departamento departamento, Estado estado);
}
package com.amei.amei.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amei.amei.department.entity.Departamento;
import com.amei.amei.department.repository.DepartmentRepository;
import com.amei.amei.employee.dto.EmpleadoDTO;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.repository.EmpleadoRepository;
import com.amei.amei.utils.Estado;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Método para crear un nuevo empleado
    public Empleado createEmployee(Integer departmentId, EmpleadoDTO empleadoDTO) {
        // Verificar que el departamento exista
        Departamento departamento = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con ID " + departmentId));

                // Verificar si el departamento está inactivo
        if (departamento.getEstado() == Estado.INACTIVO) {
            throw new IllegalStateException("El departamento está inactivo y no se pueden agregar empleados");
        }

        // Crear el empleado usando los datos del DTO
        Empleado empleado = new Empleado();
        empleado.setNombres(empleadoDTO.getNombres());
        empleado.setApellidos(empleadoDTO.getApellidos());
        empleado.setEdad(empleadoDTO.getEdad());
        empleado.setRol(empleadoDTO.getRol());
        empleado.setSalario(empleadoDTO.getSalario());
        empleado.setFechaIngreso(empleadoDTO.getFechaIngreso());
        empleado.setFechaSalida(empleadoDTO.getFechaSalida());
        empleado.setEstado(empleadoDTO.getEstado());
        empleado.setDepartamento(departamento);  // Asignar el departamento

        // Guardar el empleado en la base de datos
        return empleadoRepository.save(empleado);
    }
}

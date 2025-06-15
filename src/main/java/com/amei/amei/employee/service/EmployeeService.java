package com.amei.amei.employee.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amei.amei.department.entity.Departamento;
import com.amei.amei.department.repository.DepartmentRepository;
import com.amei.amei.employee.dto.EmpleadoDTO;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.repository.EmpleadoRepository;
import com.amei.amei.utils.Estado;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

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

    // Método para eliminar lógicamente un empleado
    public Empleado deleteEmployee(Integer employeeId) {
        // Buscar el empleado por su ID
        Empleado empleado = empleadoRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con ID " + employeeId));

        // Si el empleado ya está inactivo, lanzar una excepción
        if (empleado.getEstado() == Estado.INACTIVO) {
            throw new IllegalStateException("El empleado ya está inactivo");
        }

        // Cambiar el estado del empleado a INACTIVO (eliminación lógica)
        empleado.setEstado(Estado.INACTIVO);

        // Guardar los cambios en el repositorio
        return empleadoRepository.save(empleado);
    }

    // Método para obtener el empleado con el salario más alto
    public Empleado getEmpleadoConSalarioMasAlto() {
        Optional<Empleado> empleadoConSalarioMasAlto = empleadoRepository.findAll().stream()
                .max(Comparator.comparingDouble(Empleado::getSalario));

        return empleadoConSalarioMasAlto.orElseThrow(() -> new IllegalStateException("No hay empleados en la base de datos"));
    }

    // Método para obtener el empleado más joven
    public Empleado getEmpleadoMasJoven() {
        Optional<Empleado> empleadoMasJoven = empleadoRepository.findAll().stream()
                .min(Comparator.comparingInt(Empleado::getEdad));  // Usamos min para encontrar el empleado más joven

        return empleadoMasJoven.orElseThrow(() -> new IllegalStateException("No hay empleados en la base de datos"));
    }

    // Método para contar los empleados que ingresaron en el último mes
    public long getEmpleadosIngresaronUltimoMes() {
        // Obtener la fecha actual y la fecha de hace un mes
        LocalDateTime fechaLimite = LocalDateTime.now().minusMonths(1);

        // Filtrar empleados cuyo fechaIngreso sea mayor o igual a la fecha límite
        return empleadoRepository.findAll().stream()
                .filter(empleado -> {
                    // Convertimos la fecha de ingreso de tipo Date a LocalDateTime
                    LocalDateTime fechaIngreso = empleado.getFechaIngreso().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();
                    
                    // Comparamos si la fecha de ingreso es posterior a la fecha límite
                    return fechaIngreso.isAfter(fechaLimite) || fechaIngreso.isEqual(fechaLimite);
                })
                .count();
    }
}

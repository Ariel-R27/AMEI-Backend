package com.amei.amei.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amei.amei.department.dto.DepartamentoDTO;
import com.amei.amei.department.entity.Departamento;
import com.amei.amei.department.repository.DepartmentRepository;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.repository.EmpleadoRepository;
import com.amei.amei.utils.Estado;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Método para crear un nuevo departamento
    public Departamento createDepartment(DepartamentoDTO departamentoDTO) {
        // Crear la entidad Departamento usando los datos del DTO
        Departamento departamento = new Departamento();
        departamento.setNombre(departamentoDTO.getNombre());  // Nombre del departamento
        departamento.setEstado(departamentoDTO.getEstado());  // Estado por defecto (ACTIVO)
        
        // Guardar el departamento en la base de datos
        return departmentRepository.save(departamento);
    };

    // Método para eliminar un departamento lógicamente
    public Departamento deleteDepartment(Integer departmentId) {
        // Buscar el departamento por su ID
        Departamento departamento = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con ID " + departmentId));

        // Verificar si el departamento ya está inactivo
        if (departamento.getEstado() == Estado.INACTIVO) {
            throw new IllegalStateException("El departamento ya está marcado como inactivo");
        }

        // Verificar si el departamento tiene empleados activos
        List<Empleado> empleadosActivos = empleadoRepository.findByDepartamentoAndEstado(departamento, Estado.ACTIVO);
        if (!empleadosActivos.isEmpty()) {
            throw new IllegalStateException("No se puede eliminar el departamento porque tiene empleados activos");
        }

        // Cambiar el estado del departamento a INACTIVO (eliminación lógica)
        departamento.setEstado(Estado.INACTIVO);

        // Guardar los cambios en el repositorio
        return departmentRepository.save(departamento);
    }

}

package com.amei.amei.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amei.amei.employee.dto.EmpleadoDTO;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint para crear un nuevo empleado
    // Endpoint para crear un nuevo empleado
    @PostMapping("/create/{departmentId}")
    public ResponseEntity<Object> createEmployee(@PathVariable Integer departmentId,
            @RequestBody EmpleadoDTO empleadoDTO) {
        try {
            // Llamamos al servicio para crear un nuevo empleado
            Empleado nuevoEmpleado = employeeService.createEmployee(departmentId, empleadoDTO);
            return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Controlar el caso de que no se envíe el departmentId
            return new ResponseEntity<>("El departmentId es obligatorio y no se ha proporcionado.",
                    HttpStatus.BAD_REQUEST);
        }
    }
}

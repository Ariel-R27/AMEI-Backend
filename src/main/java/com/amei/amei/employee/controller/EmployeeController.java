package com.amei.amei.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    // Endpoint para eliminar lógicamente un empleado
    @PostMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
        try {
            // Llamamos al servicio para eliminar lógicamente al empleado
            employeeService.deleteEmployee(employeeId);
            return new ResponseEntity<>("Empleado eliminado lógicamente", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para obtener el empleado con el salario más alto
    @GetMapping("/highestSalary")
    public ResponseEntity<String> getEmpleadoConSalarioMasAlto() {
        try {
            Empleado empleado = employeeService.getEmpleadoConSalarioMasAlto();
            String response = "Empleado: " + empleado.getNombres() + " " + empleado.getApellidos() +
                    ", Salario: " + empleado.getSalario();
            return ResponseEntity.ok(response);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body("No hay empleados en la base de datos");
        }
    }

    // Endpoint para obtener el empleado más joven
    @GetMapping("/lowerAge")
    public ResponseEntity<String> getEmpleadoMasJoven() {
        try {
            Empleado empleado = employeeService.getEmpleadoMasJoven();
            String response = "Empleado: " + empleado.getNombres() + " " + empleado.getApellidos() +
                    ", Edad: " + empleado.getEdad();
            return ResponseEntity.ok(response);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body("No hay empleados en la base de datos");
        }
    }

    // Endpoint para obtener el número de empleados que ingresaron en el último mes
    @GetMapping("/countLastMonth")
    public ResponseEntity<String> getEmpleadosIngresaronUltimoMes() {
        long count = employeeService.getEmpleadosIngresaronUltimoMes();
        return ResponseEntity.ok("Número de empleados que ingresaron en el último mes: " + count);
    }
}

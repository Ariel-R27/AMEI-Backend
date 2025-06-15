package com.amei.amei.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amei.amei.department.dto.DepartamentoDTO;
import com.amei.amei.department.entity.Departamento;
import com.amei.amei.department.service.DepartmentService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    
    //Endpoint para crear un nuevo departamento
    // Endpoint para crear un nuevo departamento
    @PostMapping("/create")
    public ResponseEntity<Departamento> createDepartment(@RequestBody DepartamentoDTO departamentoDTO) {
        // Llamamos al servicio para crear el departamento
        Departamento nuevoDepartamento = departmentService.createDepartment(departamentoDTO);
        return new ResponseEntity<>(nuevoDepartamento, HttpStatus.CREATED);  // Retornamos el nuevo departamento con status 201 (CREADO)
    }

    // Endpoint para eliminar lógicamente un departamento
    @PostMapping("/delete/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer departmentId) {
        try {
            // Llamamos al servicio para eliminar lógicamente el departamento
            departmentService.deleteDepartment(departmentId);
            return new ResponseEntity<>("Departamento eliminado lógicamente", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
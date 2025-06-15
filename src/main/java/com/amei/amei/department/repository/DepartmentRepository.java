package com.amei.amei.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amei.amei.department.entity.Departamento;

public interface DepartmentRepository extends JpaRepository<Departamento, Integer> {
    
}

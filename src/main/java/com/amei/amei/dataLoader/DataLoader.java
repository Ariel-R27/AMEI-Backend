package com.amei.amei.dataLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amei.amei.department.entity.Departamento;
import com.amei.amei.department.repository.DepartmentRepository;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.repository.EmpleadoRepository;
import com.amei.amei.utils.Estado;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    private DepartmentRepository departamentoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @PostConstruct
    public void loadData() throws ParseException {

         // Formato de fecha: "dd/MM/yyyy HH:mm"
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        // Establecer fechas específicas para los empleados
        String fechaIngresoStr1 = "10/02/2021 09:00"; 
        String fechaIngresoStr2 = "11/03/2020 10:00"; 
        String fechaIngresoStr3 = "11/03/2020 09:00"; 
        String fechaIngresoStr4 = "12/05/2021 08:30";
        String fechaSalida1 = "20/05/2024 18:00";

        // Convertir las cadenas a objetos Date
        Date fechaIngreso1 = sdf.parse(fechaIngresoStr1);
        Date fechaIngreso2 = sdf.parse(fechaIngresoStr2);
        Date fechaIngreso3 = sdf.parse(fechaIngresoStr3);
        Date fechaIngreso4 = sdf.parse(fechaIngresoStr4);
        Date fechaSalida = sdf.parse(fechaSalida1);

        // Cargar datos de ejemplo para los departamentos
        Departamento depto1 = new Departamento();
        depto1.setNombre("Sistemas");
        depto1.setEstado(Estado.ACTIVO); 
        departamentoRepository.save(depto1);

        Departamento depto2 = new Departamento();
        depto2.setNombre("Contabilidad");
        depto2.setEstado(Estado.ACTIVO);  
        departamentoRepository.save(depto2);

        Departamento depto3 = new Departamento();
        depto3.setNombre("RRHH");
        depto3.setEstado(Estado.INACTIVO); 
        departamentoRepository.save(depto3);

        Departamento depto4 = new Departamento();
        depto4.setNombre("People");
        depto4.setEstado(Estado.ACTIVO);  
        departamentoRepository.save(depto4);

        // Cargar datos de ejemplo para los empleados
        Empleado emp1 = new Empleado();
        emp1.setNombres("Luis");
        emp1.setApellidos("Pérez");
        emp1.setEdad(22);
        emp1.setRol("Developer");
        emp1.setSalario(500);
        emp1.setFechaIngreso(fechaIngreso1);
        emp1.setEstado(Estado.ACTIVO);  
        emp1.setDepartamento(depto1);  // Relación con el departamento
        empleadoRepository.save(emp1);

        Empleado emp2 = new Empleado();
        emp2.setNombres("Maria");
        emp2.setApellidos("Gonzalez");
        emp2.setEdad(25);
        emp2.setRol("Analyst");
        emp2.setSalario(550);
        emp2.setFechaIngreso(fechaIngreso2);
        emp2.setEstado(Estado.ACTIVO);  
        emp2.setDepartamento(depto1);  
        empleadoRepository.save(emp2);

        Empleado emp3 = new Empleado();
        emp3.setNombres("Pedro");
        emp3.setApellidos("Gómez");
        emp3.setEdad(30);
        emp3.setRol("Manager");
        emp3.setSalario(600);
        emp3.setFechaIngreso(fechaIngreso3);
        emp3.setFechaSalida(fechaSalida);  
        emp3.setEstado(Estado.INACTIVO);  
        emp3.setDepartamento(depto2);  
        empleadoRepository.save(emp3);

        Empleado emp4 = new Empleado();
        emp4.setNombres("José");
        emp4.setApellidos("López");
        emp4.setEdad(20);
        emp4.setRol("Intern");
        emp4.setSalario(300);
        emp4.setFechaIngreso(fechaIngreso4);
        emp4.setEstado(Estado.ACTIVO);  
        emp4.setDepartamento(depto2);  
        empleadoRepository.save(emp4);
    }
}

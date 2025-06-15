package com.amei.amei.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.repository.EmpleadoRepository;

public class EmpleadoServiceTest {
    /*
    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmployeeService empleadoService;

    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    public void setup() throws ParseException {
        MockitoAnnotations.openMocks(this);

        // Formato de fecha: "dd/MM/yyyy HH:mm"
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        // Establecer fechas específicas para los empleados
        String fechaIngresoStr1 = "01/06/2025 00:00"; 
        String fechaIngresoStr2 = "10/05/2025 00:00"; 

        // Convertir las cadenas a objetos Date
        Date fechaIngreso1 = sdf.parse(fechaIngresoStr1);
        Date fechaIngreso2 = sdf.parse(fechaIngresoStr2);

        // Crear empleados de ejemplo
        empleado1 = new Empleado();
        empleado1.setId(1);
        empleado1.setNombres("Juan");
        empleado1.setApellidos("Perez");
        empleado1.setEdad(22);
        empleado1.setFechaIngreso(fechaIngreso1);
        
        empleado2 = new Empleado();
        empleado2.setId(2);
        empleado2.setNombres("Maria");
        empleado2.setApellidos("Gonzalez");
        empleado2.setEdad(19);
        empleado2.setFechaIngreso(fechaIngreso2);
    }

    @Test
    public void testGetEmpleadoMasJoven() {
        // Mockear el comportamiento del repositorio
        List<Empleado> empleados = Arrays.asList(empleado1, empleado2);
        when(empleadoRepository.findAll()).thenReturn(empleados);

        // Llamar al servicio
        Empleado empleadoMasJoven = empleadoService.getEmpleadoMasJoven();

        // Verificar que el empleado más joven es el de ID 2 (Maria)
        assertNotNull(empleadoMasJoven);
        assertEquals(empleado2.getId(), empleadoMasJoven.getId());
        assertEquals(empleado2.getEdad(), empleadoMasJoven.getEdad());
    }

    @Test
    public void testGetEmpleadoMasJovenCuandoNoHayEmpleados() {
        // Mockear el comportamiento del repositorio
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList());

        // Esperar que se lance una excepción
        assertThrows(IllegalStateException.class, () -> empleadoService.getEmpleadoMasJoven());
    }
    */
}

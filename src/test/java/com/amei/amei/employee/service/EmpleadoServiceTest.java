package com.amei.amei.employee.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.repository.EmpleadoRepository;
import com.amei.amei.department.repository.DepartmentRepository;
import com.amei.amei.employee.service.EmployeeService;
import com.amei.amei.employee.dto.EmpleadoDTO;
import com.amei.amei.utils.Estado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class EmpleadoServiceTest {
     @Mock
    private EmpleadoRepository empleadoRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private EmployeeService empleadoService;

    private Empleado empleado1, empleado2;
    private EmpleadoDTO empleadoDTO;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        // Crear un empleado de ejemplo
        empleado1 = new Empleado();
        empleado1.setId(1);
        empleado1.setNombres("Juan");
        empleado1.setApellidos("Perez");
        empleado1.setEdad(25);
        empleado1.setSalario(4500.0);
        empleado1.setFechaIngreso(new Date());
        empleado1.setEstado(Estado.ACTIVO);

        empleado2 = new Empleado();
        empleado2.setId(2);
        empleado2.setNombres("Maria");
        empleado2.setApellidos("Gonzalez");
        empleado2.setEdad(22);
        empleado2.setSalario(5000.0);
        empleado2.setFechaIngreso(new Date());
        empleado2.setEstado(Estado.ACTIVO);

        empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombres("Carlos");
        empleadoDTO.setApellidos("Diaz");
        empleadoDTO.setEdad(30);
        empleadoDTO.setRol("Developer");
        empleadoDTO.setSalario(6000.0);
    }

    @Test
    public void testCreateEmployee() {
        // Simulamos la creación del departamento y la respuesta
        when(departmentRepository.findById(1)).thenReturn(Optional.of(new Departamento()));
        when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado1);

        Empleado result = empleadoService.createEmployee(1, empleadoDTO);

        assertNotNull(result);
        assertEquals("Carlos", result.getNombres());
    }

    @Test
    public void testCreateEmployeeWithInactiveDepartment() {
        // Simulamos que el departamento está inactivo
        Departamento inactiveDepartment = new Departamento();
        inactiveDepartment.setEstado(Estado.INACTIVO);
        when(departmentRepository.findById(1)).thenReturn(Optional.of(inactiveDepartment));

        // Esperamos que se lance una excepción
        assertThrows(IllegalStateException.class, () -> empleadoService.createEmployee(1, empleadoDTO));
    }

    @Test
    public void testDeleteEmployee() {
        when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleado1));
        when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado1);

        Empleado result = empleadoService.deleteEmployee(1);

        assertEquals(Estado.INACTIVO, result.getEstado());
    }

    @Test
    public void testGetEmpleadoConSalarioMasAlto() {
        // Simulamos que el repositorio tiene dos empleados
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        Empleado result = empleadoService.getEmpleadoConSalarioMasAlto();

        assertEquals(empleado2.getId(), result.getId()); // El empleado con salario más alto es Maria
    }

    @Test
    public void testGetEmpleadoMasJoven() {
        // Simulamos que el repositorio tiene dos empleados
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        Empleado result = empleadoService.getEmpleadoMasJoven();

        assertEquals(empleado2.getId(), result.getId()); // El empleado más joven es Maria
    }

    @Test
    public void testGetEmpleadosIngresaronUltimoMes() {
        // Simulamos la respuesta de los empleados
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        long result = empleadoService.getEmpleadosIngresaronUltimoMes();

        assertEquals(2, result); // Asumimos que ambos empleados ingresaron en el último mes
    }
}

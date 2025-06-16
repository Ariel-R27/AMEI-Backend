package com.amei.amei.employee.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.amei.amei.employee.controller.EmployeeController;
import com.amei.amei.employee.dto.EmpleadoDTO;
import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeController.class) 
public class EmpleadoControllerTest {
    
    @Mock
    private EmployeeService empleadoService;

    @Autowired
    private MockMvc mockMvc;  // Inyecta el MockMvc automáticamente

    @BeforeEach
    public void setup() {
        // No es necesario configurar MockMvc aquí, ya que @WebMvcTest lo hace
    }

    @Test
    public void testCreateEmployee() throws Exception {
        // Arrange
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombres("Luis");
        empleadoDTO.setApellidos("Gonzalez");
        empleadoDTO.setEdad(30);
        empleadoDTO.setRol("Developer");
        empleadoDTO.setSalario(3500.0);
        
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombres("Luis");
        nuevoEmpleado.setApellidos("Gonzalez");
        nuevoEmpleado.setEdad(30);
        nuevoEmpleado.setRol("Developer");
        nuevoEmpleado.setSalario(3500.0);

        when(employeeService.createEmployee(1, empleadoDTO)).thenReturn(nuevoEmpleado);
        
        mockMvc.perform(post("/employee/create/1")
                .contentType("application/json")
                .content("{\"nombres\":\"Luis\",\"apellidos\":\"Gonzalez\",\"edad\":30,\"rol\":\"Developer\",\"salario\":3500.0}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"nombres\":\"Luis\",\"apellidos\":\"Gonzalez\",\"edad\":30,\"rol\":\"Developer\",\"salario\":3500.0}"));
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        Integer employeeId = 1;
        mockMvc.perform(post("/employee/delete/" + employeeId))
                .andExpect(status().isOk())
                .andExpect(content().string("Empleado eliminado lógicamente"));
    }

    @Test
    public void testGetEmpleadoConSalarioMasAlto() throws Exception {
        // Arrange
        Empleado empleado = new Empleado();
        empleado.setNombres("Pedro");
        empleado.setApellidos("Gomez");
        empleado.setSalario(6000.0);

        when(employeeService.getEmpleadoConSalarioMasAlto()).thenReturn(empleado);

        // Act and Assert
        mockMvc.perform(get("/employee/highestSalary"))
                .andExpect(status().isOk())
                .andExpect(content().string("Empleado: Pedro Gomez, Salario: 6000.0"));
    }

    @Test
    public void testGetEmpleadoMasJoven() throws Exception {
        // Arrange
        Empleado empleado = new Empleado();
        empleado.setNombres("Maria");
        empleado.setApellidos("Lopez");
        empleado.setEdad(19);

        when(employeeService.getEmpleadoMasJoven()).thenReturn(empleado);

        // Act and Assert
        mockMvc.perform(get("/employee/lowerAge"))
                .andExpect(status().isOk())
                .andExpect(content().string("Empleado: Maria Lopez, Edad: 19"));
    }
    
    @Test
    public void testGetEmpleadosIngresaronUltimoMes() throws Exception {
        // Arrange
        long count = 5; // Ejemplo de empleados ingresados en el último mes

        when(employeeService.getEmpleadosIngresaronUltimoMes()).thenReturn(count);

        // Act and Assert
        mockMvc.perform(get("/employee/countLastMonth"))
                .andExpect(status().isOk())
                .andExpect(content().string("Número de empleados que ingresaron en el último mes: 5"));
    }
}

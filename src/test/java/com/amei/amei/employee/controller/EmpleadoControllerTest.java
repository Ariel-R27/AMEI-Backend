package com.amei.amei.employee.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.amei.amei.employee.entity.Empleado;
import com.amei.amei.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest(EmployeeController.class)  // Usamos WebMvcTest para los controladores
public class EmpleadoControllerTest {
    /* 
    @Mock
    private EmployeeService empleadoService;

    @Autowired
    private MockMvc mockMvc;  // Inyecta el MockMvc automáticamente

    @BeforeEach
    public void setup() {
        // No es necesario configurar MockMvc aquí, ya que @WebMvcTest lo hace por nosotros
    }

    @Test
    public void testGetEmpleadoMasJoven() throws Exception {
        // Crear un empleado de ejemplo
        Empleado empleado = new Empleado();
        empleado.setNombres("Maria");
        empleado.setApellidos("Gonzalez");
        empleado.setEdad(19);

        // Simula el comportamiento del servicio
        when(empleadoService.getEmpleadoMasJoven()).thenReturn(empleado);

        // Realizar la solicitud GET y validar la respuesta
        mockMvc.perform(get("/employee/lowerAge"))
                .andExpect(status().isOk()) // Espera un estado OK (200)
                .andExpect(content().string("Empleado: Maria Gonzalez, Edad: 19")); // Verifica que el contenido de la respuesta sea correcto
    }

    @Test
    public void testGetEmpleadoMasJovenCuandoNoHayEmpleados() throws Exception {
        // Simula que no hay empleados (lanza una excepción)
        when(empleadoService.getEmpleadoMasJoven()).thenThrow(IllegalStateException.class);

        // Realizar la solicitud GET y verificar que la respuesta sea "Not Found" (404)
        mockMvc.perform(get("/employee/lowerAge"))
                .andExpect(status().isNotFound()); // Espera un estado Not Found (404)
    }
                 */
}

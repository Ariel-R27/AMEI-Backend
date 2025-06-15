# AMEI - Aplicación de Gestión de Empleados y Departamentos

Este proyecto es una aplicación para gestionar empleados y departamentos dentro de una empresa. La aplicación está construida con **Spring Boot** para el backend y **H2** como base de datos en memoria.

## Tecnologías Utilizadas

- **Backend**: 
  - Spring Boot (v3.5.0)
  - Spring Data JPA
  - H2 (Base de datos en memoria)
  - Java 17

## Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/AMEI.git
   cd AMEI
   ```
2. **Configurar el entorno de desarrollo**:
   - Asegúrate de tener Java 17 instalado.
   - Abre el proyecto en tu IDE favorito (como IntelliJ IDEA, Spring Tool Suite, etc.).
   - Ejecuta el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```
## Endpoints
- POST /department/create: Crea un nuevo departamento.
- POST /department/delete/{departmentId}: Elimina lógicamente un departamento.
- GET /employees: Obtiene todos los empleados.
- POST /employee/create: Crea un nuevo empleado.

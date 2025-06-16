# AMEI - Aplicación de Gestión de Empleados y Departamentos

Este proyecto es un backend desarrollado utilizando Spring Boot para la gestión de empleados y departamentos, y Angular para la interfaz de usuario, con Docker para la contenedorización de ambos componentes.

## Tecnologías Utilizadas

- **Backend**: 
  - Java 17
  - Maven 3.x o superior
  - Spring Boot (v3.5.0)
  - Spring Data JPA
  - H2 (Base de datos en memoria)
  - Docker (Opcional para contenedorización)

- **Frontend**: 
  - Node.js 16.x o superior
  - Angular CLI
  - Docker (Opcional para contenedorización)

## Arquitectura
La aplicación sigue una arquitectura Monolítica con las siguientes partes clave:
- **Backend(Spring Boot)**: Proporciona la lógca de negocio, acceso a la base de datos y sirve las APIs necesarias para gestionar empleados y departamentos.
  - Servicios: Encargados de realizar las operaciones sobre los empleados y departamentos.
  - Repositorios: Encargados de la persistencia de datos utilizando JPA y una base de datos en memoria H2.
  - Controladores: Exponen las APIs RESTful que permiten interacturar con el backend.

- **Frontend(Angular)**: Utiliza Forms para el formulario de empleados y departamentos, además de consumir las APIs proporcionadas por el backend.

- **Docker**: Los servicios se han contenedorizado utilizando Docker para facilitar su ejecución y despliegue en cualquier entorno.

## Instalación o Ejecución

### Backend 

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/AMEI.git
   cd AMEI-Backend
   ```
2. **Configurar el entorno de desarrollo**:
   - Asegúrate de tener Java 17 instalado.
   - Ejecuta el proyecto con Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
**El backend se ejecutará en http://localhost:8080**.
Alternativamente, para ejecutar en Docker:
  - Construir la imagen de Docker.
  ```bash
     docker build -t amei-backend .
  ```
  - Ejecutar el contenedor.
  ```bash
     docker run -p 8080:8080 amei-backend
  ```
3. **Verificar las APIs:**
Las APIs disponibles para pruebas son:
- /employee/create/{departmentId} (Método POST): Crea un nuevo empleado.
- /employee/highestSalary (Método GET): Obtiene el empleado con el salario más alto.
- /employee/lowerAge (Método GET): Obtiene el empleado más joven.
- /employee/countLastMonth (Método GET): Obtiene el número de empleados que ingresaron en el último mes.
- /department/create (Método POST): Crea un nuevo departamento.

### Frontend
1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Ariel-R27/AMEI-Frontend.git
   cd AMEI-Frontend
   ```
2. **Instalar dependencias**:
   ```bash
   npm install
   ```
3. **Ejecutar el servidor de desarollo**:
   ```bash
   ng serve
   ```
**El frontend se ejecutará en http://localhost:4200**.

### Pruebas Unitarias
1. **Para ejecutar las pruebas del backend:**
   ```bash
   mvn test
   ```
## Funcionalidades 
1. Empleado: CRUD básico de empleados, con validaciones en el frontend y en el backend.
2. Departamento: CRUD básico de departamentos.
3. Estadísticas:
  -Salario más alto.
   -Empleado más joven.
   -Número de empleados que ingresaron en el último mes.

## Diseño de Base de datos 

La base de datos está configurada en memoria utilizando H2, con las siguientes tablas: 
  - Empleado: Almacena información sobre los empleados, como nombres, edad, salario, fecha de ingreso, estado, etc.}
  - Departamento: Almacena información sobre los departamentos, con nombre y estado.

## Notas
- Este proyecto utiliza CORS para habilitar el acceso desde el frontend (Angular) al backend (Spring Boot).
- Las validaciones de formularios se realizan utilizando ReactiveForms en Angular.
- Para la contenedorización, se utiliza Docker para crear imágenes y ejecutar ambos servicios (frontend y backend) de manera independiente y eficiente.

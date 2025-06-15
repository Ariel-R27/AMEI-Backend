package com.amei.amei.employee.dto;

import java.sql.Date;
import com.amei.amei.utils.Estado;

public class EmpleadoDTO {

    private String nombres;        // Nombre del empleado
    private String apellidos;      // Apellidos del empleado
    private int edad;              // Edad del empleado
    private String rol;            // Rol del empleado
    private double salario;        // Salario del empleado
    private Date fechaIngreso;     // Fecha de ingreso del empleado
    private Date fechaSalida;      // Fecha de salida (puede ser null si es activo)

    // Getters y setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    // Método para obtener el estado por defecto (ACTIVO)
    public Estado getEstado() {
        return Estado.ACTIVO;  // Estado por defecto será "ACTIVO"
    }
}
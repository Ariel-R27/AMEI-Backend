package com.amei.amei.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

import com.amei.amei.department.entity.Departamento;
import com.amei.amei.utils.Estado;

@Entity(name = "EMPLEADO")
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_id")
    private int id; // Identificador único para el empleado

    @Column(name = "Employee_name")
    private String nombres;

    @Column(name = "Employee_last_name")
    private String apellidos;

    @Column(name = "Age")
    private int edad;

    @Column(name = "Role")
    private String rol;

    @Column(name = "Salary")
    private double salario;

    @Column(name = "Init_date")
    private Date fechaIngreso;

    @Column(name = "End_date")
    private Date fechaSalida;

    @Column(name = "Employee_status")
    @Enumerated(EnumType.STRING)
    private Estado estado; // true si está activo, false si está inactivo

    @ManyToOne
    @JoinColumn(name = "Department_id", referencedColumnName = "Department_id")
    private Departamento departamento;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Estado isEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Departamento getDepartamento(){
        return departamento;
    }

    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }
}

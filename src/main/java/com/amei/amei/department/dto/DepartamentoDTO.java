package com.amei.amei.department.dto;

import com.amei.amei.utils.Estado;

public class DepartamentoDTO {

    private String nombre;

    // Constructor
    public DepartamentoDTO(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el estado por defecto (ACTIVO)
    public Estado getEstado() {
        return Estado.ACTIVO;  // Estado por defecto será "ACTIVO"
    }
}

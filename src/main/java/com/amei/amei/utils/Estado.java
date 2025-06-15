package com.amei.amei.utils;

public enum Estado {
    ACTIVO,
    INACTIVO;

    private static Estado[] list = Estado.values();
    
    private static Estado getEstado(int i) {
        return list[i];
    }
}

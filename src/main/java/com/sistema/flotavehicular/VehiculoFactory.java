package com.sistema.flotavehicular;

public interface VehiculoFactory {
    
    Vehiculo crearVehiculo(String marca, String matricula, int capacidad);
    
    
}

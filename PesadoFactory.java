package com.sistema.flotavehicular;


public class PesadoFactory implements VehiculoFactory {
       

    @Override
    public Vehiculo crearVehiculo(String marca, String matricula, String capacidad) {
    return new Pesado(marca, matricula, capacidad);
    }

   
    
}
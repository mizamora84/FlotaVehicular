package com.sistema.flotavehicular;


public class LivianoFactory implements VehiculoFactory {
    
    
    @Override
    public Vehiculo crearVehiculo (String marca,String matricula,String capacidad){
    return new Liviano(marca, matricula, capacidad);
    }

}
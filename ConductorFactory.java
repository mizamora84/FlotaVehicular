package com.sistema.flotavehicular;

public class ConductorFactory implements TrabajadoresFactory{
    
    @Override
    public Trabajadores crearTrabajador(String nombre, String id){
    return new Conductor(nombre, id);
    }
    
}

//hablamefgh
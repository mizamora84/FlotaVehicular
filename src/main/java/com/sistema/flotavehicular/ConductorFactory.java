package com.sistema.flotavehicular;

public class ConductorFactory implements TrabajadoresFactory{
    
    @Override
    public Trabajadores crearTrabajador(String nombre, int id){
    return new Conductor(nombre, id);
    }
    
}
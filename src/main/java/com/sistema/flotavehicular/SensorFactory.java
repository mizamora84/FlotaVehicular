package com.sistema.flotavehicular;


public class SensorFactory implements DispositivoFactory{
    
    @Override
    public Dispositivo crearDispositivo(String marca, int numero){
    return new Sensor(marca, numero);
    }
    
}

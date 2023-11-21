package com.sistema.flotavehicular;


public class SensorFactory implements DispositivoFactory{
    
    @Override
    public Dispositivo crearDispositivo(String tipo, String numero){
    return new Sensor(tipo, numero);
    }
    
}

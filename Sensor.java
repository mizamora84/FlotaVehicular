package com.sistema.flotavehicular;


public class Sensor implements Dispositivo {
    
    
    private String tipo;
    private String numero;

    

    // Constructor que recibe los atributos durante la creación
    public Sensor(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

   
    
    
    
    @Override
    public String mostrarInfoDispositivo() {
        
        return "Sensor : " + tipo + ", número: " + numero;
    
    
    }
    
    
}

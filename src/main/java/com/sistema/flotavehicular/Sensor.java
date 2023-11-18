package com.sistema.flotavehicular;

import javax.swing.JOptionPane;

public class Sensor implements Dispositivo {
    
    
    private String marca;
    private int numero;

    

    // Constructor que recibe los atributos durante la creación
    public Sensor(String marca, int numero) {
        this.marca = marca;
        this.numero = numero;
    }

   
    
    
    
    @Override
    public void mostrarInfoDispositivo() {
        
        JOptionPane.showMessageDialog(null, "Sensor - Marca: " + marca + ", número" + numero);
    
    
    }
    
    
}

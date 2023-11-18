package com.sistema.flotavehicular;

import javax.swing.JOptionPane;

public class Conductor implements Trabajadores {
    
    private String nombre;
    private int id;
    private Tarea tareaAsignada;


    public Conductor(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    
    
public void mostrarCondictor() {
    }

    @Override
    public void mostrarTrabajadores() {
    
    JOptionPane.showMessageDialog(null, "Conductor: " + nombre + ", id: " + id);


    }
    
    public void realizarTarea() {
        
        
        if (tareaAsignada != null) {
            JOptionPane.showMessageDialog(null, "Conductor " + nombre + " está realizando la tarea: " + tareaAsignada.getDescripcion());
        } else {
            JOptionPane.showMessageDialog(null, "Conductor " + nombre + " no tiene tareas asignadas.");
        }
    
    };


    
    
}
package com.sistema.flotavehicular;

import javax.swing.JOptionPane;
//hi cristian
//hola
public class Conductor implements Trabajadores {
    
    private String nombre;
    private String id;
    private Tarea tareaAsignada;


    public Conductor(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    
    
public void mostrarConductor() {
    }

    @Override
    public String mostrarTrabajadores() {
    
    return "Conductor: " + nombre + ", id: " + id;


    }
    
    public void realizarTarea() {
        
        
        if (tareaAsignada != null) {
            JOptionPane.showMessageDialog(null, "Conductor " + nombre + " está realizando la tarea: " + tareaAsignada.getDescripcion());
        } else {
            JOptionPane.showMessageDialog(null, "Conductor " + nombre + " no tiene tareas asignadas.");
        }
    
    };


    
    
}

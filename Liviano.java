package com.sistema.flotavehicular;

import javax.swing.JOptionPane;


class Liviano implements Vehiculo {
    
    private Conductor conductor;
    private String marca;
    private String matricula;
    private String capacidad;
    private Dispositivo dispositivo;
    private Tarea tareaAsignada;
    
    
    

    // Constructor que recibe los atributos durante la creación
    public Liviano(String marca, String matricula, String capacidad) {
        this.marca = marca;
        this.matricula = matricula;
        this.capacidad = capacidad;
       
    }
    
    @Override
        public String mostrarVehiculofull() {
       return "Marca:" + marca +", Matrícula: " + matricula + ", Capacidad: " + capacidad;
    }
    
    
    
    @Override
    public void realizarTarea(){
        
 if (tareaAsignada != null) {
           JOptionPane.showMessageDialog(null, "El vehiculo de matricula " + matricula + " está realizando la tarea: " + tareaAsignada.getDescripcion());
        } else {
            JOptionPane.showMessageDialog(null, "El vehiculo de matricula " + matricula + " no tiene tareas asignadas.");
        }
      
   
    }

    @Override
    public void asignarConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    @Override
    public void asignarDispositivo(Dispositivo dispositivo) {
    this.dispositivo = dispositivo;

    }

    
    
    
    
}

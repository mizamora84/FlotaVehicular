package com.sistema.flotavehicular;


public class Tarea {
    
    private String descripcion;
    private String prioridad;
    private String conductor;

    public Tarea(String descripcion, String prioridad, String conductor) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.conductor = conductor;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
    public String AsignarTarea(String conductor, String descripcion, String prioridad){
    
    return "El conductor, y el vehiculo: " + conductor +"\n"+"Tarea: "+descripcion+"\nPrioridad: "+prioridad;
        }
}

package com.tecnara_enterprise.modelos;

import java.io.Serializable;

public class Ubicacion implements Serializable{
    private int id;
    private String nombre;
    
    
    public Ubicacion(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
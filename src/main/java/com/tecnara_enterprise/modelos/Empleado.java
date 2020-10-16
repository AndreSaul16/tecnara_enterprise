package com.tecnara_enterprise.modelos;


public class Empleado {
    private int id;
    private String nombre;
    private String password;
    private Ubicacion ubicacion;
    private int salario;
    
    public Empleado(int id, String nombre, String password, Ubicacion ubicacion, int salario){
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.ubicacion = ubicacion;
        this.salario = salario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getSalario() {
        return salario;
    }
    
    public void setSalario(int salario) {
        this.salario = salario;
    }
}

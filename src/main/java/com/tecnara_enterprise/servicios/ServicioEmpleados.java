package com.tecnara_enterprise.servicios;

import com.tecnara_enterprise.DAO.DAOEmpleados;
import com.tecnara_enterprise.DAO.DAOUbicaciones;
import com.tecnara_enterprise.modelos.Empleado;

import java.sql.SQLException;
import java.util.List;

public class ServicioEmpleados {
    
    DAOEmpleados dao;
    DAOUbicaciones daoU;
    
     public ServicioEmpleados() {
        this.dao = new DAOEmpleados();
        this.daoU = new DAOUbicaciones();
    }

    public List<Empleado> listAll() {
        List<Empleado> empleados = this.dao.listarEmpleados();
        return empleados;
    }

    public String borrarEmpleado(int id) throws Exception {
        if (id != -1) {
            int resultado = this.dao.eliminarEmpleado(id);
            if (1 == resultado) {
                return "¡Se ha eliminado el Empleado!";
            } else {
                return "¡No pudimos eliminarlo!";
            }
        }
        return "¡No pudimos eliminarlo!";
    }

    public String añadirEmpleado(Empleado persona) throws Exception {
        int resultado = this.dao.añadirEmpleado(persona);
        if (1 == resultado) {
            return "¡Se ha añadido el nuevo empleado!";
        } else {
            return "¡No pudimos añadir al nuevo empleado!";
        }
    }

    public String actulizarEmpleado(String nombre, String password, int ubicacion, 
            int salario, int id) {
        
        if (nombre != null && password!= null && ubicacion != -1&& salario != -1 && id != -1){
            
            Empleado persona = new Empleado(id, nombre, password, daoU.getUbicacion(ubicacion), salario);
            int result = this.dao.actualizarEmpleado(persona);
            
            if(result==1){
                return "Has actualizado un usuario";
            }
            
        }
        return "No pudimos actualizar el usuario";
    }

    public Empleado getEmpleado(int id) throws SQLException{

        return this.dao.getEmpleado(id);
    }
}

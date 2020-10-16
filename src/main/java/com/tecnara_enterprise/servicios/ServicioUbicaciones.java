package com.tecnara_enterprise.servicios;

import com.tecnara_enterprise.DAO.DAOUbicaciones;
import com.tecnara_enterprise.modelos.Ubicacion;

import java.sql.SQLException;
import java.util.List;

public class ServicioUbicaciones {
    
    DAOUbicaciones dao;
    
     public ServicioUbicaciones() {
        this.dao = new DAOUbicaciones();
        
    }

    public List<Ubicacion> listAll() throws Exception {
        return this.dao.listarUbicaciones();
    }

    public String borrarUbicacion(int id) throws Exception {
        if (id != -1) {
            int resultado = this.dao.eliminarUbicacion(id);
            if (1 == resultado) {
                return "¡Se ha eliminado la ubicacion!";
            }
        }
        return "¡No pudimos eliminar la ubicacion!";
    }

    public String añadirUbicacion(Ubicacion lugar) throws Exception {
        int resultado = this.dao.añadirUbicacion(lugar);
        if (1 == resultado) {
            return "¡Se ha añadido una nueva ubicacion!";
        }
        return "¡No pudimos añadir la nueva ubicacion!";
    }

    public String actulizarUbicacion(int id, String nombre) throws SQLException {
        
        if (nombre != null && id != -1){
          
            Ubicacion lugar = new Ubicacion(id, nombre);
            int result = this.dao.actualizarUbicacion(lugar);
            
            if(result==1){
                return "Has modificado una ubicacion";
            } 
        }
        return "No pudimos modificar la ubicacion";
    }

    public Ubicacion getUbicacion(int id) throws SQLException{
        return this.dao.getUbicacion(id);
    }
}


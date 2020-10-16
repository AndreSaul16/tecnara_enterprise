package com.tecnara_enterprise.DAO;

import java.sql.ResultSet;
import java.sql.Statement;

public class DAOUsuarios extends Conexion{
    
    public boolean verificarUsuario(String user, String pass) throws Exception {
               
        String query = "SELECT * FROM usuarios WHERE nombre LIKE '"+user+"' AND password LIKE '"+pass+"';";
        
        try (Statement stmt = this.conexion.createStatement()) {
            ResultSet result = stmt.executeQuery(query);
            
            if(result.next()) {
                return true;
            }
        }
        
        return false;
    }
}

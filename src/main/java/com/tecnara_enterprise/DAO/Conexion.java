package com.tecnara_enterprise.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public Connection conexion;
    
    public Conexion(){
        try {
            String url = "jdbc:mysql://localhost:3306/tecnara_enterprise?serverTimezone=" + TimeZone.getDefault().getID();
            String usuario = "root";
            String clave = "admin";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error SQL: " + ex.toString());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}

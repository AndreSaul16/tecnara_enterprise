package com.tecnara_enterprise.DAO;

import com.tecnara_enterprise.modelos.Ubicacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUbicaciones extends Conexion{
    
     public int añadirUbicacion(Ubicacion ubicacion) throws Exception {
        String sqlInsert = "INSERT INTO ubicaciones (nombre, id) VALUES ('" + ubicacion.getNombre()+ "', '" +
               ubicacion.getId() + "')";
       
        Statement  stmt = this.conexion.createStatement();
        int result = stmt.executeUpdate(sqlInsert);
        stmt.close();
        
        return result;
    }
   
    public int eliminarUbicacion(int id) throws Exception {
        String sql= "DELETE FROM ubicaciones WHERE id=?";
        PreparedStatement preparedStatement= this.conexion.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        
        return result;
    }
  
    public List<Ubicacion> listarUbicaciones() throws Exception {
        
        List<Ubicacion> ubicaciones = new ArrayList();
        
        String query = "SELECT * FROM ubicaciones";
        
        Statement stmt = this.conexion.createStatement();
        ResultSet result = stmt.executeQuery(query);
        
        while(result.next()) {
            
            int id = result.getInt("id");
            String nombre = result.getString("nombre");
            
            Ubicacion lugar = new Ubicacion(id, nombre);
            ubicaciones.add(lugar);
        }
        stmt.close();
        return ubicaciones;
    }
    
     public Ubicacion getUbicacion(int id) {
        
             Ubicacion ubicacion= null;
         try {
             
             String sql= "SELECT * FROM ubicaciones WHERE id= ?";
             PreparedStatement preparedStatement= this.conexion.prepareStatement(sql);
             preparedStatement.setInt(1, id);
             ResultSet resultSet= preparedStatement.executeQuery();
             
             if (resultSet.next()){
                 ubicacion = new Ubicacion
                                (resultSet.getInt("id"),
                                        resultSet.getString("nombre"));
             }
             preparedStatement.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(DAOUbicaciones.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             return ubicacion;
         }
        
    }

    public int actualizarUbicacion(Ubicacion lugar) throws SQLException {

        String sql= "UPDATE ubicaciones SET nombre= ? WHERE id= ?";
        PreparedStatement preparedStatement= this.conexion.prepareStatement(sql);
        preparedStatement.setInt(1,lugar.getId());
        preparedStatement.setString(2,lugar.getNombre());

        int result= preparedStatement.executeUpdate();
        preparedStatement.close();

        return result;
    }
}

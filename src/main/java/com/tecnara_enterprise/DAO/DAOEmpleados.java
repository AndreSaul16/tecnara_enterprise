package com.tecnara_enterprise.DAO;

import com.tecnara_enterprise.modelos.Empleado;
import com.tecnara_enterprise.modelos.Ubicacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleados extends Conexion {

    public DAOEmpleados() {
        super();
    }

    public int añadirEmpleado(Empleado empleado) throws Exception {
        String sqlInsert = "INSERT INTO empleados (id, nombre, password, ubicacion, salario) VALUES ('" + empleado.getId() + "', '"
                + empleado.getNombre() + "', '" + empleado.getPassword() + "', '" + empleado.getUbicacion().getId() + "', '" + empleado.getSalario() + "')";

        Statement stmt = this.conexion.createStatement();
        int result = stmt.executeUpdate(sqlInsert);
        stmt.close();

        return result;
    }

    public int eliminarEmpleado(int id) throws Exception {
        String sql = "DELETE FROM empleados WHERE id=?";
        PreparedStatement preparedStatement = this.conexion.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();

        return result;
    }

    public List<Empleado> listarEmpleados() {

        List<Empleado> empleados = new ArrayList();
        try {

            String query = "SELECT * FROM empleados JOIN ubicaciones ON empleados.ubicacion=ubicaciones.id";

            Statement stmt = this.conexion.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {

                int id = result.getInt("empleados.id");
                String nombre = result.getString("empleados.nombre");
                String password = result.getString("empleados.password");
                int ubicacion = result.getInt("empleados.ubicacion");
                int salario = result.getInt("empleados.salario");
                String ubicacionNombre = result.getString("ubicaciones.nombre");
                int ubicacionID = result.getInt("ubicaciones.id");

                Empleado persona = new Empleado(id, nombre, password, new Ubicacion(ubicacionID, ubicacionNombre), salario);
                empleados.add(persona);
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return empleados;
        }
    }

    public Empleado getEmpleado(int employeeId) throws SQLException {

        Empleado empleado = null;
        try {

            String query = "SELECT * FROM empleados JOIN ubicaciones ON empleados.ubicacion=ubicaciones.id WHERE empleados.id = "+employeeId+";";

            Statement stmt = this.conexion.createStatement();
            ResultSet result = stmt.executeQuery(query);

            if (result.next()) {

                int id = result.getInt("empleados.id");
                String nombre = result.getString("empleados.nombre");
                String password = result.getString("empleados.password");
                int ubicacion = result.getInt("empleados.ubicacion");
                int salario = result.getInt("empleados.salario");
                String ubicacionNombre = result.getString("ubicaciones.nombre");
                int ubicacionID = result.getInt("ubicaciones.id");

                empleado = new Empleado(id, nombre, password, new Ubicacion(ubicacionID, ubicacionNombre), salario);
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return empleado;
        }

    }

    public int actualizarEmpleado(Empleado persona) {

        int result = -1;
        try {
            String sql = "UPDATE empleados SET nombre= ?, password= ?, ubicacion= ?, salario= ? WHERE id= "+persona.getId()+";";
            PreparedStatement preparedStatement = this.conexion.prepareStatement(sql);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getPassword());
            preparedStatement.setInt(3, persona.getUbicacion().getId());
            preparedStatement.setInt(4, persona.getSalario());
            preparedStatement.setInt(5, persona.getId());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return result;
        }
    }

}

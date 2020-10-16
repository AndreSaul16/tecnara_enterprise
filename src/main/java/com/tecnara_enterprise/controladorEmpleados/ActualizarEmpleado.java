package com.tecnara_enterprise.controladorEmpleados;

import com.tecnara_enterprise.modelos.Empleado;
import com.tecnara_enterprise.servicios.ServicioEmpleados;
import com.tecnara_enterprise.servicios.ServicioUbicaciones;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ActualizarEmpleado", urlPatterns = {"/actualizarEmpleado"})
public class ActualizarEmpleado extends HttpServlet {

    ServicioEmpleados servicio = new ServicioEmpleados();
    ServicioUbicaciones servicioUbicaciones = new ServicioUbicaciones();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1. cargar el empleado - recoger el id que te llega por parametro
        try{
            Empleado empleado = servicio.getEmpleado(Integer.parseInt(request.getParameter("id")));
            if (empleado != null) {
                HttpSession misesion = request.getSession(true);
                misesion.setAttribute("nombre", empleado.getNombre());
                misesion.setAttribute("id", empleado.getId());
                misesion.setAttribute("password", empleado.getPassword());
                misesion.setAttribute("ubicacion", empleado.getUbicacion().getId());
                misesion.setAttribute("salario", empleado.getSalario());
                misesion.setAttribute("ubicaciones", servicioUbicaciones.listAll());
            }
            //2. redirigir al jsp que tiene el formulario de actualizar
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empleados/actualizarEmpleado.jsp");
            rd.forward(request, response);
           
        }catch (IOException | NumberFormatException | SQLException | ServletException e){
           System.out.println("ERROR => "+e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ActualizarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        int ubicacion = Integer.parseInt(request.getParameter("sede"));
        int salario = Integer.parseInt(request.getParameter("salario"));

        servicio.actulizarEmpleado(nombre, password, ubicacion, salario, id);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empleados/listarEmpleados.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

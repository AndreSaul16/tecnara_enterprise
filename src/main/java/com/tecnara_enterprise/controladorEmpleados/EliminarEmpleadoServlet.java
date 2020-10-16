package com.tecnara_enterprise.controladorEmpleados;

import com.tecnara_enterprise.servicios.ServicioEmpleados;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "eliminarEmpleadoServlet", urlPatterns = {"/eliminarEmpleado"})
public class EliminarEmpleadoServlet extends HttpServlet {

    ServicioEmpleados servicio = new ServicioEmpleados();

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             String id = request.getParameter("id");
             String resultado;
             resultado = servicio.borrarEmpleado(Integer.parseInt(id));
             HttpSession miSesion = request.getSession(true);
             miSesion.setAttribute("resultado", resultado);

             RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empleados/borrarEmpleado.jsp");
             rd.forward(request, response);

         } catch (Exception e) {
             e.printStackTrace();
         }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

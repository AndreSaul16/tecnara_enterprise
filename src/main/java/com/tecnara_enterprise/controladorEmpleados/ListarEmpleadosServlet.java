package com.tecnara_enterprise.controladorEmpleados;


import com.tecnara_enterprise.modelos.Empleado;
import com.tecnara_enterprise.servicios.ServicioEmpleados;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarEmpleadosServlet", urlPatterns = {"/listarEmpleados"})
public class ListarEmpleadosServlet extends HttpServlet {

    ServicioEmpleados servicio = new ServicioEmpleados();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Empleado> personas = servicio.listAll();
            request.getSession(true).setAttribute("empleados", personas);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empleados/listarEmpleados.jsp");
            rd.forward(request, response);

        } catch (Exception e){
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

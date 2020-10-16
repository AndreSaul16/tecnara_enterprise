package com.tecnara_enterprise.controladorEmpleados;

import com.tecnara_enterprise.modelos.Empleado;
import com.tecnara_enterprise.modelos.Ubicacion;
import com.tecnara_enterprise.servicios.ServicioEmpleados;
import com.tecnara_enterprise.servicios.ServicioUbicaciones;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AgregarEmpleadoServlet", urlPatterns = {"/agregarEmpleado"})
public class AgregarEmpleadoServlet extends HttpServlet {

    ServicioEmpleados servicio = new ServicioEmpleados();
    ServicioUbicaciones servicioUbicaciones = new ServicioUbicaciones();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Ubicacion> lugares = servicioUbicaciones.listAll();

            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("lugares", lugares);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empleados/agregarEmpleado.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            int salario = Integer.parseInt(request.getParameter("salario"));
            
            
            int lugar = Integer.parseInt(request.getParameter("ubicacion"));
            Ubicacion ubicacion = servicioUbicaciones.getUbicacion(lugar);
            

            Empleado persona = new Empleado(id, nombre, password, ubicacion, salario);
            servicio.añadirEmpleado(persona);

            List<Empleado> empleados = servicio.listAll();

            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("empleados", empleados);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empleados/listarEmpleados.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

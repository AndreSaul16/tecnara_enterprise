package com.tecnara_enterprise.controladorUbicaciones;

import com.tecnara_enterprise.modelos.Ubicacion;
import com.tecnara_enterprise.servicios.ServicioUbicaciones;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ListarUbicacionesServlet", urlPatterns = {"/listarUbicaciones"})
public class ListarUbicacionesServlet extends HttpServlet {

    ServicioUbicaciones servicio = new ServicioUbicaciones();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Ubicacion> lugares = servicio.listAll();
            request.getSession(true).setAttribute("ubicaciones", lugares);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ubicaciones/listarUbicaciones.jsp");
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

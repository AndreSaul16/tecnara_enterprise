package com.tecnara_enterprise.controladorUbicaciones;

import com.tecnara_enterprise.modelos.Ubicacion;
import com.tecnara_enterprise.servicios.ServicioUbicaciones;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AgregarUbicacionServlet", urlPatterns = {"/agregarUbicacion"})
public class AgregarUbicacionServlet extends HttpServlet {

    ServicioUbicaciones servicio = new ServicioUbicaciones();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ubicaciones/agregarUbicacion.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre = request.getParameter("nombre");
            int id = Integer.parseInt(request.getParameter("id"));

            Ubicacion lugar = new Ubicacion(id, nombre);
            servicio.añadirUbicacion(lugar);

            List<Ubicacion> lugares = servicio.listAll();

            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("lugares", lugares);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listarUbicaciones.jsp");
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

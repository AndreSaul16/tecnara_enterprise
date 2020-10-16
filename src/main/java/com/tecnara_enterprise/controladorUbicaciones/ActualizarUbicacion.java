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

@WebServlet(name = "ActualizarUbicacion", urlPatterns = {"/actualizarUbicacion"})
public class ActualizarUbicacion extends HttpServlet {

    ServicioUbicaciones servicio = new ServicioUbicaciones();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Ubicacion lugar = servicio.getUbicacion(Integer.parseInt(request.getParameter("id")));

        if (lugar != null) {
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("nombre", lugar.getNombre());
            misesion.setAttribute("id", lugar.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ubicaciones/actualizarUbicacion.jsp");
        rd.forward(request, response);

        }catch (Exception e){
        e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String nombre = request.getParameter("nombre");
            int id = Integer.parseInt(request.getParameter("id"));

            servicio.actulizarUbicacion(id, nombre);

            List<Ubicacion> lugares = servicio.listAll();

            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("Ubicaciones", lugares);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listarUbicaciones.jsp");
            rd.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

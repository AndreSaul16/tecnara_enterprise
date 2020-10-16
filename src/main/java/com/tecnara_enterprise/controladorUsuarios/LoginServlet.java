package com.tecnara_enterprise.controladorUsuarios;

import com.tecnara_enterprise.modelos.Login;
import com.tecnara_enterprise.servicios.ServicioLogin;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    ServicioLogin servicio = new ServicioLogin();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/usuarios/loginUsuarios.jsp");
        rd.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        try{
        String usuario = (String) request.getParameter("usuario");
        String pass = (String) request.getParameter("pass");

        boolean verificarUsuario = servicio.comprobarUsuario(usuario, pass);

        HttpSession miSesion = request.getSession(true);
        RequestDispatcher rd = null;
        if(verificarUsuario){

            Login login = new Login(usuario, verificarUsuario);

            miSesion.setAttribute("login", login);
            miSesion.setAttribute("loginError", null);

            response.sendRedirect("/tecnara_enterprise/listarEmpleados");
        }else{
            miSesion.setAttribute("loginError", "Credenciales inválidas");
            response.sendRedirect("/tecnara_enterprise/login");
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

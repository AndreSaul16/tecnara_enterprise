
<%@page import="java.util.List"%>
<%@page import="com.tecnara_enterprise.modelos.Ubicacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#ceffd1;">
        <%@include file="/WEB-INF/utils/menu.jspf" %>
        <%HttpSession misesion= request.getSession(false);
            String nombre = (String)misesion.getAttribute("nombre");
            int id = (int) misesion.getAttribute("id");
            List<Ubicacion> ubicaciones = (List<Ubicacion>) misesion.getAttribute("ubicaciones");
        %>
        <table border>
            <tr>
                <td><strong><%= id %></strong></td>
                <td><strong><%= nombre %></strong></td>
            </tr>
        </table>
        <table>
            <form method="put" action="http://localhost:8080/empleados/actualizarEmpleados">

                ID:<input type="text" name="id" value="<%= id %>">
                <br><br>

                Nombre:<input type="text" name="nombre" value="<%= nombre %>">
                <br><br>

                <input type="hidden" name="id" value="<%= id %>">
                <input type="submit" value="Actualizar">
            </form>
    </body>
</html>

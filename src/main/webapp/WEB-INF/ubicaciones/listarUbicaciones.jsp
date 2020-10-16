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
    <%
        HttpSession misesion = request.getSession(false);
        List<Ubicacion> ubicaciones = (List<Ubicacion>) misesion.getAttribute("ubicaciones");
    %>
    <table border>
        <tr>
            <td><strong>Estas son las ubicaciones disponibles:</strong></td>
        </tr>
        <% for (Ubicacion sedes : ubicaciones) {
        %>
        <tr>
            <td><%= sedes.getNombre() %></td>
        </tr>
        <% }%>
    </table>
    </body>
</html>

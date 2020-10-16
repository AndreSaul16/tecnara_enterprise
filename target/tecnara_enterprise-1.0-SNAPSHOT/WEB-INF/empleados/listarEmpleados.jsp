<%@page import="com.tecnara_enterprise.modelos.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#ceffd1;">
        <%@include file="/WEB-INF/utils/menu.jspf" %>
        <%HttpSession misesion = request.getSession(false);
            List<Empleado> empleadosList = (List<Empleado>) misesion.getAttribute("empleados");
        %>
        <table border>
            <tr>
                <td><strong>Id</strong></td>
                <td><strong>Nombre</strong></td>
                <td><strong>Ubicacion</strong></td>
                <td><strong>Salario</strong></td>
            </tr>
            <% for (Empleado persona : empleadosList) {
            %>
            <tr>
                <td><%= persona.getId()%></td>    
                <td><%= persona.getNombre()%></td>
                <td><%= persona.getUbicacion().getNombre() %></td>
                <td><%= persona.getSalario()%></td>  
            </tr>
                <a href="/tecnara_enterprise/eliminarEmpleado?id=<%=persona.getId()%>">
                  <img height="30px" width="20px" src="</WEB-INF/tecnara_enterprise/img/cubo-de-la-basura.png" alt=""/>
                </a>  
                <a href="/tecnara_enterprise/actualizarEmpleado?id=<%=persona.getId()%>">
                  <img height="30px" width="20px" src="</WEB-INF/tecnara_enterprise/img/editar1.png" alt=""/>
                </a>  
            <% }%>
             
        </table>
    </body>
</html>

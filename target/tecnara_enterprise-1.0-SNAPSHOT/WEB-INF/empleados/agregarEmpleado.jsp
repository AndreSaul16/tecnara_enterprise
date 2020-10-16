<%@page import="java.util.List"%>
<%@page import="com.tecnara_enterprise.modelos.Ubicacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#ceffd1;>
          
        <%@include file="/WEB-INF/utils/menu.jspf" %>
        <%HttpSession misesion = request.getSession(false);
            List<Ubicacion> ubicaciones = (List<Ubicacion>) misesion.getAttribute("lugares");
        %>
        <h1>Añade el usuario</h1>
        
        <form method="post" action="/tecnara_enterprise/agregarEmpleado">

            ID:<input type="text" name="id">
            
            Nombre:<input type="text" name="nombre">
            <br><br>

            Password:<input type="text" name="password">
            <br><br>

            Ubicacion:
            <select name="ubicacion">
                <%
                    for (Ubicacion lugar : ubicaciones){
                %>
            <option value="<%=lugar.getId() %>"> <%= lugar.getNombre() %> </option>
                <% }%>
            </select>
            <br><br>

            Salario:<input type="text" name="salario">
            <br><br>

            <button class="boton" type="submit" value="enviar">Añadir</button>

        </form>
    </body>
</html>

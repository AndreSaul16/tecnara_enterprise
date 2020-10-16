
<%@page import="com.tecnara_enterprise.modelos.Ubicacion"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualiza los datos de un empleado</title>
</head>
<body style="background-color:#ceffd1;">
    <h1>Vas a modificar al empleado: </h1>
    <%
        HttpSession misesion= request.getSession(true);
        String nombre = (String)misesion.getAttribute("nombre");
        String password = (String) misesion.getAttribute("password");
        int ubicacion = (int) misesion.getAttribute("ubicacion");
        int salario = misesion.getAttribute("salario") != null ? (int)misesion.getAttribute("salario") : -1;
        int id = misesion.getAttribute("id") != null ? (int)misesion.getAttribute("id") : -1;
        List<Ubicacion> ubicaciones = (List<Ubicacion>) misesion.getAttribute("ubicaciones");
    %>
    
<table>
    <form method="put" action="http://localhost:8080/tecnara_enterprise/actualizarEmpleado">

        Nombre:<input type="text" name="nombre" value="<%= nombre %>">
        <br><br>

        Password:<input type="text" name="password" value="<%= password %>">
        <br><br>

        Ubicacion:
        <select name="sede">
        <%
            if(ubicaciones != null){
                for (Ubicacion lugar : ubicaciones){
        %>
                    <option value="<%= lugar.getId() %>"> <%= lugar.getNombre() %> </option>
                <% }%>
            <% }%>
        </select>
        <br><br>

        Salario:<input type="number" name="salario" value="<%= salario %>">
        <br><br>

        <input type="hidden" name="id" value="<%= id %>">
        <input type="submit" value="actualizar">
    </form>
</table>
</body>
</html>

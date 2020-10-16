
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#ceffd1;">
    <%@include file="/WEB-INF/utils/menu.jspf" %>
    <form method="post" action="/tecnara_enterprise/agregarUbicaciones">
        Nombre:<input type="text" name="nombre">
        <br><br>
        ID:<input type="text" name="id">
        <button class="boton" type="submit" value="enviar">Añadir</button>
    </form>
    </body>
</html>

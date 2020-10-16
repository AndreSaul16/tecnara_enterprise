<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body style="background-color:#cefaff;">
      
        <br>
        <h1>INICIA SESION: </h1>
        <br>
        <% String msgError = (String)request.getSession().getAttribute("loginError"); 
        if(msgError != null && !msgError.isEmpty()){
        %>
            <%= msgError %>
        <%}%>
        <form method="POST" action="/tecnara_enterprise/login" >
        <input type="text" name="user" value="Usuario" />
        <input type="password" name="pass" value="Contraseña" />
        <input type="submit" value="Ingresar" />
        </form>
    </body>
</html>

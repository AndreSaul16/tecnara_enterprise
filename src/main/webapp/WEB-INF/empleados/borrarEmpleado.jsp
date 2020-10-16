<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#ceffd1;>
        <%@include file="/WEB-INF/utils/menu.jspf" %>
        <%
            HttpSession miSesion= request.getSession(false);
            String resultado= (String) miSesion.getAttribute("resultado");
        %>
        <h4><%= resultado%></h4>
    </body>
</html>

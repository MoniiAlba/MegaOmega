<%-- 
    Document   : TableData
    Created on : 15/05/2019, 12:51:54 AM
    Author     : soeur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
    </head>
    <body>
        <%-- Este código se copia y pega en todas las vistas que tengamos --%>
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("userName") != null){
                out.print("<h1> Datos de tabla " + request.getParameter("tableName"));
                
            }else{
                response.sendRedirect("dataValidation.jsp");
            }
            
        %>
    </body>
</html>

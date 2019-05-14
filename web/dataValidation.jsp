<%-- 
    Document   : dataValidation
    Created on : 14/05/2019, 12:32:00 PM
    Author     : soeur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validando datos</title>
    </head>
    <body>
        <%
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String dbName = request.getParameter("dbName");
            RestClient callRest = new RestClient();
            if(password != null && userName != null && dbName != null){ //viene de newUser
                String answer = callRest.putHtml(userName, password, dbName);
                JSONObject userData;
                JSONParser parser = new JSONParser();

                userData = (JSONObject) parser.parse(answer);
                HttpSession mySession = request.getSession();
                mySession.setAttribute("userName", userData.get("userName"));
                mySession.setAttribute("dbName", userData.get("dbName"));
                mySession.setMaxInactiveInterval(10);
                response.sendRedirect("tables.jsp");
            }else{
                if (password != null && userName != null) {
                    
                    String answer = callRest.postHtml(userName, password);
                    JSONObject userData;
                    JSONParser parser = new JSONParser();

                    userData = (JSONObject) parser.parse(answer);
                    HttpSession mySession = request.getSession();
                    mySession.setAttribute("userName", userData.get("userName"));
                    mySession.setAttribute("dbName", userData.get("dbName"));
                    mySession.setMaxInactiveInterval(10);
                    response.sendRedirect("tables.jsp");
                } else {
                    out.println("<p> Sesión no iniciada </p>");
                    out.println("<a href='index.html'> Iniciar sesión </a>");
                }
            }
            
        %>
    </body>
</html>

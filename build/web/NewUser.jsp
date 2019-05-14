<%-- 
    Document   : NewUser
    Created on : 14/05/2019, 12:33:20 PM
    Author     : soeur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo usuario</title>
    </head>
    <body>
        <h1>Crear nuevo usuario</h1>
        <script>
            function sendUser(){
                var user = document.getElementById(user).value;
                var pass = document.getElementById(pwd).value;
                var db = document.getElementById(db).value;
                
                if(user != "" && pass != "" && db != ""){
                    return true;
                }else{
                    alert("Datos incompletos");
                    return false
                }
                    
            }
        </script>
        <form action="dataValidation.jsp" method="POST" onsubmit="return sendUSer()">
            Usuario: <input id="user" type="text" name="userName" value="" /> <br>
            Contraseña: <input id="pwd" type="password" name="password" value="" /> <br>
            Nombre de la base de datos: <input id="db" type="text" name="dbName" value="" /> <br>
            <input type="submit" value="OK" />
        </form>
    </body>
</html>

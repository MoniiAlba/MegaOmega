<%-- 
    Document   : Tables
    Created on : 14/05/2019, 12:37:52 PM
    Author     : soeur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <%-- Este código se copia y pega en todas las vistas que tengamos --%>
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("userName") != null){
                out.print("<h1> Bienvenido " + mySession.getAttribute("userName"));
                out.print("<input type='hidden' id='dbName' value='" + mySession.getAttribute("dbName") + "' />");
                
            }else{
                response.sendRedirect("dataValidation.jsp");
            }
            
        %>
        <body onload="loadNewContent()">
                
        <script>
            function loadNewContent() {
                var userData = actualizaUsuario();
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                ajaxRequest.onreadystatechange = function(){
                    if (ajaxRequest.readyState==4 && ajaxRequest.status==200){
                        var xmlDataBase = ajaxRequest.responseXML;
                        var tabla="";
                        var totTablas = xmlDataBase.getElementsByTagName("tables");
                        if(totTablas.length>0){
                            for(var i = 0; i < totTablas.length; i++){
                                tabla += "<tr> <td>";
                                tabla+=totTablas[i].childNodes[0].nodeValue + "</td> </tr>";
                            }
                        }else{
                            tabla="<tr><td>No hay tablas en la base de datos por el momento</td></tr>";
                        }
                        
                        document.getElementById("tableName").innerHTML=tabla;
                    }
                }
                ajaxRequest.open("PUT", "http://localhost:8080/MegaOmega/webresources/db", true /*async*/);
                ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
                var params = "dbName="+userData.dbName+"&userName="+userData.userName+"&psswrd="+userData.password;
                console.log(params);
                ajaxRequest.send(params);
            }
            
            function actualizaUsuario(){
                var usuario = JSON.parse(localStorage.getItem('user'));
                if(usuario.dbName==""){
                    usuario.dbName=document.getElementById("dbName").value;
                    localStorage.setItem('user', JSON.stringify(usuario));
                }
                return usuario;
            }
        </script>
        
        <form >
            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre de las tablas</th>
                    </tr>
                </thead>
                <tbody id="tableName">
                    <tr>
                        <td>No hay tablas en la base de datos por el momento</td>
                    </tr>
                </tbody>
            </table>

        </form>
        
        
        
    </body>
</html>

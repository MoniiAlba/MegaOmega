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
    
        <body onload="loadNewContent()">
                
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
                                var nomTabla=totTablas[i].childNodes[0].nodeValue;
                                tabla += "<tr> <td id='"+nomTabla.toLowerCase()+"' class='clickable' onclick='cambiaSelec("+'"'+nomTabla+'"'+")'>";                                
                                tabla+=nomTabla.toLowerCase() + " </td> </tr>";
                            }
                        }else{
                            tabla="<tr><td>No hay tablas en la base de datos por el momento. Es hora de crear una! :D</td></tr>";
                        }
                        
                        document.getElementById("tableName").innerHTML=tabla;
                    }
                }
                ajaxRequest.open("PUT", "http://localhost:8080/MegaOmega/webresources/db", true /*async*/);
                ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
                var params = "dbName="+userData.dbName+"&userName="+userData.userName+"&psswrd="+userData.password;
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
            
            function cambiaSelec(nombre){
                if(document.getElementById("tablaSelec").value != ""){
                    document.getElementById(document.getElementById("tablaSelec").value.toLowerCase()).classList.remove("clicked");
                }
                document.getElementById("tablaSelec").value=nombre;
                document.getElementById(nombre.toLowerCase()).classList.add("clicked");
                
                document.getElementById("tablaButton").disabled="";
                
            }
        </script>
        
        <br>
        <br>
        <div style="display: flex;">
            <form class="form" action="TableData.jsp" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th style="padding: 5px;">Nombre de las tablas</th>
                        </tr>
                    </thead>
                    <tbody id="tableName">

                    </tbody>
                </table>
                <input type="hidden" id="tablaSelec" value="" />
                <input type="submit" id="tablaButton" value="Ver tabla" disabled="disabled" />
            </form>

            <form action="CreateTable.jsp" method="POST" style="margin-left: 100px;">
                <input type="submit" value="Crear tabla" />
            </form>
        
        </div>
        <style>
            .clickable{
                cursor: pointer;
                font-size: 25px;
                text-align: center;
                background-color: white;
            }
            
            .clickable:hover{
                background-color: #aadbd6;
            }
            
            .clicked{
                font-size: 25px;
                text-align: center;
                background-color: #acf8f0;
            }
            
            .form{
                margin-left: 50px;
            }
        </style>
        
    </body>
</html>

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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/solid.css" integrity="sha384-ioUrHig76ITq4aEJ67dHzTvqjsAP/7IzgwE7lgJcg2r7BRNGYSK0LwSmROzYtgzs" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/fontawesome.css" integrity="sha384-sri+NftO+0hcisDKgr287Y/1LVnInHJ1l+XC7+FOabmTTIK0HnE2ID+xxvJ21c5J" crossorigin="anonymous">
    </head>
    <body onload="setTable()">
        <%-- Este código se copia y pega en todas las vistas que tengamos --%>
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("userName") != null){
                out.print("<h1 style='margin: 10px'> Datos de la tabla " + request.getParameter("tableName")+"</h1>");
                out.print("<input type='hidden' id='tableName' name='' value='"+request.getParameter("tableName")+"' />");
                
            }else{
                response.sendRedirect("dataValidation.jsp");
            }
            
        %>
        
        <br>
        <br>
        <div class="tableContainer">
            Número de registros: <input type="text" id="numRecords" name="numRecords" value="3" size="4"/>
            <br>
            <br>
            
            <table border="1" class="tableContent">
                <thead id="tableFields">
                </thead>
                <tbody id="tableRows">
                </tbody>
            </table>
            <div class="arrows">
                <i class="fas fa-chevron-left arrow"></i>
                <i class="fas fa-chevron-right arrow"></i> 
            </div>
            
            <br>
            <br>
            <h4>Modificar o insertar datos: </h4>
            <div id="inputsToEdit">
                <input type="text" name="d" value="d" disabled="disabled" />
            </div>
            <br>
            <br>
            
            <input type="hidden" id="selectedRow" name="" value="" />
            <input type="submit" id="insertButton" value="Insertar registro" onclick="callInsert()" /> 
            <input type="submit" id="deleteButton" value="Eliminar registro" disabled="disabled" onclick="callDelete()" />
            <input type="submit" id="updateButton" value="Editar registro" disabled="disabled" onclick="callUpdate()" />
        </div>
        
        <script>
            var numR = document.getElementById("numRecords").value;
            var fields;
            var base = 0;
            var tableName = document.getElementById("tableName").value;
            var userData = getUser();
            var table;
            function setTable(){
                
                getRecords();
                
                 
                
            }
            
            function getFields(){
                
            }
            
            function getRecords(){
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                ajaxRequest.onreadystatechange = function(){
                    if (ajaxRequest.readyState==4 && ajaxRequest.status==200){
                        table = JSON.parse(ajaxRequest.responseText);
                        console.log(table);
                        if(table.length > 0){
                            fields = Object.keys(table[0]);
                            var numFields = fields.length;
                            var theader = "";
                            var tbody = "";
                            var inputs = "";
                            console.log(Object.keys(table[0]));
                            theader += "<tr>"
                            for(var i = 0; i < fields.length; i++){
                                theader += "<th class='tableValue'>" + fields[i] + "</th>"
                                inputs += fields[i] + "<input style='margin: 5px' type='text' id='input"+fields[i]+"' value='' /> <br>";
                            }
                            theader += "</tr>";
                            //llenar body
                            for(var j = 0; j < numR; j ++){ //each row
                                var idRow = "row"+j;
                                tbody += "<tr class='tableRow' id='"+idRow+"' onclick='rowSelected("+'"row'+j+'")' + "'> ";
                                for(var i = 0; i < fields.length; i++){
                                    tbody += "<td class='tableValue' id='"+idRow+ "-" + fields[i] +"' value='"+table[j][fields[i]]+"'>"+ table[j][fields[i]] +"</td>";
                                }
                                tbody += "</tr>";
                            }
                        }
                        
                        document.getElementById("tableFields").innerHTML = theader;
                        document.getElementById("tableRows").innerHTML = tbody;
                        document.getElementById("inputsToEdit").innerHTML = inputs;
                    }
                }
                var params = "dbName="+userData.dbName.trim()+"&tableName="+tableName+"&userName="+userData.userName.trim()+"&password="+userData.password.trim()+"&start="+base+"&end="+numR;
                ajaxRequest.open("GET", "http://localhost:8080/MegaOmega/webresources/record?"+params, true /*async*/);
                ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
                
                ajaxRequest.send();
            }
            
            function callInsert() {
                let inputs = document.getElementById('inputsToEdit').childNodes
                let user = JSON.parse(window.localStorage.getItem("user"))
                console.log(user)
                
                let payload = {
                    tableName: tableName.trim(),
                    userName: user.userName.toString().trim(),
                    dbName: user.dbName.toString().trim(),
                    password: user.password.toString().trim()
                }
                
                let encodedFields = Object.keys(payload).map(function(k) {
                    return encodeURIComponent(k) + '=' + encodeURIComponent(payload[k])
                }).join('&')
                console.log(encodedFields)
                var xhr = new XMLHttpRequest();
                xhr.open("GET", "http://localhost:8080/MegaOmega/webresources/table?"+encodedFields, true);
                xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                xhr.onload = function () {
                        parser = new DOMParser();
                        var response = JSON.parse(xhr.responseText);
                        if (xhr.readyState == 4 && xhr.status == "200") {
                            console.log(response);
                            let data = []
                            for(let i = 0; i < inputs.length; i++){
                                if(inputs[i].nodeName == 'INPUT'){
                                    data.push(inputs[i])
                                }
                            }
                            let typeApproved = true
                            let columnValue = null
                            let columns = {}
                            for(let i =0; i < response.length; i++){
                                console.log(response[i].type == "4")
                                if(response[i].type === "4"){
                                        try{
                                            columnValue = parseInt(data[i].value).toString()
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                if(response[i].type === "8"){
                                        try{
                                            columnValue = parseFloat(data[i].value).toString()
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                if(response[i].type === "12"){
                                        try{
                                            columnValue = "'"+data[i].value.toString()+"'"
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                
                                columns[response[i].name] = columnValue
                                console.log(inputs)
                                console.log(columns)
                            }
                            
                            encodedFields += "&values=" + JSON.stringify(columns)
                            
                            var xhr2 = new XMLHttpRequest();
                            xhr2.open("POST", "http://localhost:8080/MegaOmega/webresources/record", true);
                            xhr2.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                            xhr2.onload = function () {
                                    parser = new DOMParser();
                                    var response = parser.parseFromString(xhr2.responseText,"text/xml");
                                    if (xhr2.readyState == 4 && xhr2.status == "200") {
                                        console.log(response);
                                    } else {
                                        console.error(response);
                                    }
                            }
                            
                            xhr2.send(encodedFields)
                            
                            console.log(encodedFields)
                            
                        } else {
                            console.error(response);
                        }
                }
                xhr.send()       
            }
           
            function callDelete(){
               let inputs = document.getElementById('inputsToEdit').childNodes
                let user = JSON.parse(window.localStorage.getItem("user"))
                console.log(user)
                
                let payload = {
                    tableName: tableName.trim(),
                    userName: user.userName.toString().trim(),
                    dbName: user.dbName.toString().trim(),
                    password: user.password.toString().trim()
                }
                let primaryKey = null
                let encodedFields = Object.keys(payload).map(function(k) {
                    return encodeURIComponent(k) + '=' + encodeURIComponent(payload[k])
                }).join('&')
                console.log(encodedFields)
                var xhr = new XMLHttpRequest();
                xhr.open("GET", "http://localhost:8080/MegaOmega/webresources/table?"+encodedFields, true);
                xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                xhr.onload = function () {
                        parser = new DOMParser();
                        var response = JSON.parse(xhr.responseText);
                        if (xhr.readyState == 4 && xhr.status == "200") {
                            console.log(response);
                            let data = []
                            for(let i = 0; i < inputs.length; i++){
                                if(inputs[i].nodeName == 'INPUT'){
                                    data.push(inputs[i])
                                }
                            }
                            let typeApproved = true
                            let columnValue = null
                            let columns = {}
                            for(let i =0; i < response.length; i++){
                                
                                if(response[i].type === "4"){
                                        try{
                                            if(response[i].isPrimaryKey){
                                                primaryKey = data[i].value.toString()
                                            }
                                            columnValue = parseInt(data[i].value).toString()
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                if(response[i].type === "8"){
                                        try{
                                            if(response[i].isPrimaryKey){
                                                primaryKey = data[i].value.toString()
                                            }
                                            columnValue = parseFloat(data[i].value).toString()
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                if(response[i].type === "12"){
                                        try{
                                            if(response[i].isPrimaryKey){
                                                primaryKey = data[i].value.toString() + "'"
                                            }
                                            columnValue = "'"+data[i].value.toString()+"'"
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                
                                columns[response[i].name] = columnValue
                                console.log(inputs)
                                console.log(columns)
                            }
                            
                            encodedFields += "&primaryKey=" + primaryKey
                            var xhr2 = new XMLHttpRequest();
                            xhr2.open("POST", "http://localhost:8080/MegaOmega/webresources/row/", true);
                            xhr2.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                            xhr2.onload = function () {
                                    parser = new DOMParser();
                                    var response = parser.parseFromString(xhr2.responseText,"text/xml");
                                    if (xhr2.readyState == 4 && xhr2.status == "200") {
                                        console.log(response);
                                    } else {
                                        console.error(response);
                                    }
                            }
                            
                            xhr2.send(encodedFields)
                            
                            console.log(encodedFields)
                            
                        } else {
                            console.error(response);
                        }
                }
                xhr.send()  
            }
            
            function callUpdate(){
                let inputs = document.getElementById('inputsToEdit').childNodes
                let user = JSON.parse(window.localStorage.getItem("user"))
                console.log(user)
                
                let payload = {
                    tableName: tableName.trim(),
                    userName: user.userName.toString().trim(),
                    dbName: user.dbName.toString().trim(),
                    password: user.password.toString().trim()
                }
                
                let encodedFields = Object.keys(payload).map(function(k) {
                    return encodeURIComponent(k) + '=' + encodeURIComponent(payload[k])
                }).join('&')
                console.log(encodedFields)
                var xhr = new XMLHttpRequest();
                xhr.open("GET", "http://localhost:8080/MegaOmega/webresources/table?"+encodedFields, true);
                xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                xhr.onload = function () {
                        parser = new DOMParser();
                        var response = JSON.parse(xhr.responseText);
                        if (xhr.readyState == 4 && xhr.status == "200") {
                            console.log(response);
                            let data = []
                            for(let i = 0; i < inputs.length; i++){
                                if(inputs[i].nodeName == 'INPUT'){
                                    data.push(inputs[i])
                                }
                            }
                            let typeApproved = true
                            let columnValue = null
                            let columns = {}
                            for(let i =0; i < response.length; i++){
                                
                                if(response[i].type === "4"){
                                        try{
                                            if(response[i].isPrimaryKey){
                                                encodedFields += "&primaryKey=" + data[i].value.toString()
                                            }
                                            columnValue = parseInt(data[i].value).toString()
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                if(response[i].type === "8"){
                                        try{
                                            if(response[i].isPrimaryKey){
                                                encodedFields += "&primaryKey=" + data[i].value.toString()
                                            }
                                            columnValue = parseFloat(data[i].value).toString()
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                if(response[i].type === "12"){
                                        try{
                                            if(response[i].isPrimaryKey){
                                                encodedFields += "&primaryKey='" + data[i].value.toString() + "'"
                                            }
                                            columnValue = "'"+data[i].value.toString()+"'"
                                        }
                                        catch(e){
                                            typeApproved = false
                                        }
                                }
                                
                                columns[response[i].name] = columnValue
                                console.log(inputs)
                                console.log(columns)
                            }
                            
                            encodedFields += "&values=" + JSON.stringify(columns)
                            
                            var xhr2 = new XMLHttpRequest();
                            xhr2.open("PUT", "http://localhost:8080/MegaOmega/webresources/record", true);
                            xhr2.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                            xhr2.onload = function () {
                                    parser = new DOMParser();
                                    var response = parser.parseFromString(xhr2.responseText,"text/xml");
                                    if (xhr2.readyState == 4 && xhr2.status == "200") {
                                        console.log(response);
                                    } else {
                                        console.error(response);
                                    }
                            }
                            
                            xhr2.send(encodedFields)
                            
                            console.log(encodedFields)
                            
                        } else {
                            console.error(response);
                        }
                }
                xhr.send()    
            }
            
            function updateRecord(){
                var row = document.getElementById("selectedRow").value;
                for(var i = 0; i < fields.length; i++){                
                    document.getElementById("input"+fields[i]).value = document.getElementById(row+"-"+fields[i]).innerHTML;
                }
            }
            
            function rowSelected(idRow){
                var selected = document.getElementById("selectedRow").value;
                if(selected != ""){
                    document.getElementById(selected+"").classList.remove("clicked");
                }
                if(selected === idRow+""){ //deseleccion
                    document.getElementById("updateButton").disabled="disabled";
                    document.getElementById("deleteButton").disabled="disabled";
                    document.getElementById("insertButton").disabled="";
                    cleanInputs();
                    document.getElementById("selectedRow").value = "";
                }else{
                    document.getElementById("updateButton").disabled="";
                    document.getElementById("deleteButton").disabled="";
                    document.getElementById("insertButton").disabled="disabled";
                    document.getElementById("selectedRow").value = idRow+"";
                    document.getElementById(idRow+"").classList.add("clicked");
                    updateRecord();
                }
                
            }
            
            function cleanInputs(){
                for(var i = 0; i < fields.length; i++){                
                    document.getElementById("input"+fields[i]).value = "";
                }
            }
            
            function getUser(){
                return JSON.parse(localStorage.getItem('user'));
            }
        </script>
        
        
    </body>
    
    <style>
        .tableContainer{
            text-align: center;
            font-size: 20px;

        }

        .tableContent{
            margin: auto;
        }

        .tableValue{
            padding: 5px;
        }

        .tableRow:hover{
            padding: 5px;
            background-color: #aadbd6;
        }
        
        .clicked{
            padding: 5px;
            background-color: #acf8f0;
        }
        
        .arrows{
            display: flex;
            justify-content: space-evenly;
        }
        
        .arrow{
            cursor: pointer;
        }
        
        .arrow:active{
            color:blue;
        }
    </style>
</html>

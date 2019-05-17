<%-- 
    Document   : CreateTable
    Created on : 15/05/2019, 12:51:36 AM
    Author     : soeur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Crear tabla</title>
    </head>
    <body onload="newColumn()">
    <%-- Este código se copia y pega en todas las vistas que tengamos --%>
        <%--
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("userName") == null){
                response.sendRedirect("dataValidation.jsp");
            }
            
        --%>
        <h1>Crear nueva tabla</h1>
        <div>
            <h2>
                Nombre de la tabla : <input type="s" id="tableName">
            </h2>
            <div style="margin: 20px 0" id="columnas">
            </div>

            <input type="button" value="Añadir columna" onclick="newColumn()">
            <input type="button" value="Eliminar columna" onclick="deleteColumn()">
            <input type="button" value="Crear tabla" onclick="createTable()">
        </div>
        <script>
            var fields= [];
            var numCols = 0;
            function newColumn(){
                numCols++;
                console.log('NUMCOLS',numCols)
                var div = document.createElement("DIV");
                div.style.marginBottom = "20px";
                div.style.marginTop = "20px";
                div.id = numCols;
                
                var input = document.createElement("INPUT");
                input.id = "n" + numCols;
                input.type = "text";
                
                var labelNombre = document.createElement("LABEL");
                labelNombre.htmlFor = "text" + numCols;
                labelNombre.innerHTML="Nombre de la columna: ";
                labelNombre.style.marginLeft = "10px";
                
                var select = document.createElement("SELECT");
                select.id = "t" + numCols;
                
                var labelTipo = document.createElement("LABEL");
                labelTipo.htmlFor = "text" + numCols;
                labelTipo.innerHTML="Tipo: ";
                labelTipo.style.marginLeft = "10px";
                
                var optionVarchar = document.createElement("OPTION");
                optionVarchar.value = "Varchar(60)"
                optionVarchar.text = "Varchar"
                select.appendChild(optionVarchar)
                
                var optionInteger = document.createElement("OPTION");
                optionInteger.value = "Integer"
                optionInteger.text = "Integer"
                select.appendChild(optionInteger)
                
                var optionDouble = document.createElement("OPTION");
                optionDouble.value = "Double"
                optionDouble.text = "Double"
                select.appendChild(optionDouble)
                
                var labelPrimaryKey = document.createElement("LABEL");
                labelPrimaryKey.htmlFor = "text" + numCols;
                labelPrimaryKey.innerHTML="Primary Key: ";
                labelPrimaryKey.style.marginLeft = "10px";
                
                var inputPrimaryKey = document.createElement("INPUT");
                inputPrimaryKey.id = "pk" + numCols;
                inputPrimaryKey.type = "checkbox";
                inputPrimaryKey.setAttribute('onClick','validatePrimaryKey()')
                
                div.appendChild(labelNombre)
                div.appendChild(input)
                div.appendChild(labelTipo)
                div.appendChild(select)
                div.appendChild(labelPrimaryKey)
                div.appendChild(inputPrimaryKey)
                
                document.getElementById('columnas').append(div);
            }

            function deleteColumn(){

            if (numCols > 0){
            var cols = document.getElementById('columnas')
                    cols.removeChild(document.getElementById(numCols));
                    numCols--
            }

            }

            function createTable(){
                let colNames = []
                let hasEmptyColName = false
                let hasPrimaryKey  = false
                for (var i = 1; i <= numCols; i++){
                    
                    let name = document.getElementById("n" + i)
                    let pk = document.getElementById("pk" + i)
                    let type = document.getElementById("t" + i)
                    
                    let row = {
                        name: name.value.toString(),
                        type: type.options[type.selectedIndex].value.toString(),
                        isPrimaryKey: pk.checked.toString()
                    }
                    
                    fields.push(JSON.stringify(row))
                    
                    if(name.value == ''){
                        hasEmptyColName = true
                    }
                    
                    if(pk.checked){
                        hasPrimaryKey = true
                    }
                    colNames.push(name.value)
                }
                let namesSet = new Set(colNames)
                let duplicateNamesApproved = (namesSet.size == colNames.length) && !hasEmptyColName;
                let tableNameNotEmpty = document.getElementById("tableName").value !== ''
                
                if(duplicateNamesApproved && tableNameNotEmpty && hasPrimaryKey){
                    console.log("FIELDS",fields)
                    let user = JSON.parse(window.localStorage.getItem("user"))
                    console.log(user)
                    let payload = {
                        fields: fields, 
                        tableName: document.getElementById("tableName").value, 
                        userName: user.userName.toString().trim(), 
                        dbName: user.dbName.toString().trim(), 
                        password: user.password.toString().trim()
                    }
                    
                    console.log("PAYLOAD",payload)
                    
                    var xhr = new XMLHttpRequest();
                    xhr.open("PUT", "http://localhost:8080/MegaOmega/webresources/table", true);
                    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded; charset=utf-8');
                    xhr.onload = function () {
                            parser = new DOMParser();
                            var response = parser.parseFromString(xhr.responseText,"text/xml");
                            if (xhr.readyState == 4 && xhr.status == "200") {
                                console.log(response);
                            } else {
                                console.error(response);
                            }
                    }
                    
                    let encodedFields = Object.keys(payload).map(function(k) {
                        if(k == 'fields'){
                            let encodedURL = ''
                            for(let i = 0; i < fields.length; i++){
                                return 'fields=['+fields+']'
                            }
                        }
                        return encodeURIComponent(k) + '=' + encodeURIComponent(payload[k])
                    }).join('&')
                    console.log(encodedFields)
                    xhr.send(encodedFields);
                }
                else{
                    window.alert("ERROR: Revisa bien tus datos. Debe tener nombre de tabla, nombres de columnas distintos y una Primary Key.")
                    fields = []
                }
               
            }
            
            function validatePrimaryKey() {
                let hasPK = false;
                for (var i = 1; i <= numCols; i++){
                    pk = document.getElementById("pk" + i)
                    pk.disabled = false;
                    if(pk.checked){
                       hasPK = true; 
                    }
                }
                
                for (var i = 1; i <= numCols; i++){
                    pk = document.getElementById("pk" + i)
                    if(!pk.checked && hasPK){
                       pk.disabled = true; 
                    }
                }
            }
        </script>
    </body>
</html>

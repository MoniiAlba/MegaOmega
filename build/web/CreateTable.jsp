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
        <h1>Crear nueva tabla</h1>
        <div>
            <h2>
                Nombre de la tabla : <input type="s">
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
                var div = document.createElement("div");
                div.style.marginBottom = "20px";
                            div.style.marginTop = "20px";
                            div.id = numCols
                            div.innerHTML = ` Nombre de la columna :
                            < input type = "text" id = "n`+ numCols +`" >
                            Tipo
                            < select name = "" id = "t`+numCols+`" >
                            < option value = "Varchar(60)" > Varchar < /option>
                            < option value = "Integer" > Integer < /option>
                            < option value = "Double" > Double < /option>
                            < /select>
                            Primary key
                            < input type = "checkbox" name = "" id = "pk`+numCols+'" > ';
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
            var aux = null
                    var select = null
                    for (var i = 1; i <= numCols; i++){
            select = document.getElementById("t" + i)
                    fields.push({
                    name: document.getElementById("n" + i).value,
                            type: select.options[select.selectedIndex].value,
                            isPrimaryKey: document.getElementById("pk" + i).checked
                    })
            }
            }
        </script>
    </body>
</html>

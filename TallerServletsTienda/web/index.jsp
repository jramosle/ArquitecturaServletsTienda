<%-- 
    Document   : index
    Created on : 27-feb-2018, 20:38:33
    Author     : Nectia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina persona</title>
        <script type="text/javascript" src="lib/jquery-1.11.2.min.js"></script>
        <link rel=StyleSheet HREF="styles.css" TYPE="text/css" MEDIA=screen>
    </head>
    </head>
    <body>
        <form action='taller' method="post"> 

            <label>Nombre</label><input type ='text' name="nombre" pattern="[A-Za-z0-9]+"/>
            <label>Numero cuotas</label><input type = 'text' pattern=[1-9]{0,3} name = "cuotas"/>
            <label>Cuota inicial</label><input type = 'text' name = "inicial"/>
            <input type="submit" >
            <select>
                <option value="casa80">Casa 80 M2</option>
                <option value="casa100">Casa 100 M2</option>
                <option value="apto45">Apartamento 45 M2</option>
                <option value="apto60">Apartamento 60 M2</option>
            </select>
            <table>
                <tr>
                  <th>Company</th>
                  <th>Contact</th>
                  <th>Country</th>
                </tr>
            </table>
            
        </form>
    </body>
</html>

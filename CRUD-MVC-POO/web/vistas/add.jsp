<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD CON MVC - JAVA</title>
    </head>
    <body>
        <div>
            <h1>Agregar Registro de Estudiante</h1>
            <form action="Controlador">
                <input type="text" name="txtId" placeholder="Ingrese su documento"><br>
                <input type="text" name="txtNom" placeholder="Digite sus nombres"><br>
                <input type="text" name="txtAp1" placeholder="Digite su primer apellido"><br>
                <input type="text" name="txtAp2" placeholder="Digite su segundo apellido"><br>
                <input type="submit" name="accion" value="Agregar">
            </form>
        </div>
        
    </body>
</html>

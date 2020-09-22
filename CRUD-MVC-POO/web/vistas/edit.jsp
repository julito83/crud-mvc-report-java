<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.ModeloDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD CON MVC- JAVA</title>
    </head>
    <body>
        <div>
            <%
                ModeloDAO dao = new ModeloDAO();
                int id_doc = Integer.parseInt((String)request.getAttribute("idper"));
                Persona p = (Persona)dao.list(id_doc);
            %>
            
            <h1>Editar Registro de Estudiante</h1>
            <form action="Controlador">
                <input type="text" name="txtId" readonly="" value="<%=p.getId_doc()%>"><br>
                <input type="text" name="txtNom" value="<%=p.getNom()%>"><br>
                <input type="text" name="txtAp1" value="<%=p.getAp1()%>"><br>
                <input type="text" name="txtAp2" value="<%=p.getAp2()%>"><br>
                <input type="submit" name="accion" value="Actualizar"><br><br>
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>

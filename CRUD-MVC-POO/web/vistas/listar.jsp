<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.ModeloDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>LISTAR REGISTRO</title>
    </head>
    <body>
        <div class="container">
            <h1>Registro de los estudiantes del Colegio La Enseñanza</h1>
            <table class="table table-bordered">
                <a class="btn btn-success" href="Controlador?accion=add">Agregar registro</a> 
                <a class="btn btn-primary" href="#">Imprimir reporte</a>
                <thead>
                    <tr>
                        <th class="text-center">Documento</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Apellido 1</th>
                        <th class="text-center">Apellido 2</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    ModeloDAO dao = new ModeloDAO();
                    List<Persona>list = dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per = null;
                    
                    while (iter.hasNext()){
                        per = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%=per.getId_doc()%></td>
                        <td class="text-center"><%=per.getNom()%></td>
                        <td class="text-center"><%=per.getAp1()%></td>
                        <td class="text-center"><%=per.getAp2()%></td>
                        <td>
                            <a class ="btn btn-warning" href="Controlador?accion=edit&id=<%=per.getId_doc()%>">Editar</a>
                            <a class ="btn btn-danger" href="Controlador?accion=delete&id=<%=per.getId_doc()%>">Eliminar</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

        </div>
    </body>
</html>

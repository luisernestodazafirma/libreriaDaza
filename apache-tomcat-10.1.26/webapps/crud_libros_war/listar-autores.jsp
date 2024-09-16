<%@ page import="com.daza.api.servlet.crudlibros.beans.AutorDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<AutorDTO> autores = (List<AutorDTO>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Listar un Autor</title>
</head>
<body>

    <h1>Listado de Autores</h1>

    <table border="2">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Nacionalidad</th>
        </tr>
        <% for (AutorDTO autor : autores) { %>
        <tr>
            <td><%= autor.getId() %></td>
            <td><%= autor.getNombre() %></td>
            <td><%= autor.getNacionalidad() %></td>
        </tr>
        <% } %>
    </table>


</body>
</html>

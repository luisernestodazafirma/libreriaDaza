<%@ page import="java.util.List" %>
<%@ page import="com.daza.api.servlet.tarealibreria.dto.AutorDTO" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Listando autores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="row">
        <div class="col-md-12">
            <!-- Título de la página -->
            <h1 class="mb-4 text-center">Listado de autores</h1>

            <!-- Botones de navegación y agregar -->
            <div class="d-flex justify-content-between mb-3">
                <a href="index.jsp" class="btn btn-secondary">Inicio</a>
                <a href="agregar-autor.jsp" class="btn btn-primary">Agregar nuevo Autor</a>
            </div>

            <%
                List<AutorDTO> autores = (List<AutorDTO>) request.getAttribute("autores");
                HttpSession sesion = (HttpSession) request.getSession(false);
            %>

            <!-- Mensaje si no hay autores -->
            <% if (autores.isEmpty()) { %>
            <p class="text-center">No hay autores registrados.</p>
            <% } else { %>

            <!-- Tabla estilizada con Bootstrap -->
            <table class="table table-bordered table-hover text-center">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Nacionalidad</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <% for (AutorDTO autor : autores) { %>
                <tr>
                    <td><%= autor.getId() %></td>
                    <td><%= autor.getNombre() %></td>
                    <td><%= autor.getNacionalidad() %></td>
                    <td>
                        <% if (sesion != null && sesion.getAttribute("usuario") != null) { %>
                        <a href="autor?action=editar&id=<%= autor.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="autor?action=eliminar&id=<%= autor.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este autor?');">Eliminar</a>
                        <% } else { %>
                        No tienes permisos para editar o eliminar.
                        <% } %>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
            <% } %>
        </div>
    </div>
</div>


</body>
</html>

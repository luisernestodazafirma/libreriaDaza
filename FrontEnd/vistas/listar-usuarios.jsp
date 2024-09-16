<%@ page import="java.util.List" %>
<%@ page import="com.daza.api.servlet.tarealibreria.dto.UsuarioDTO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Usuarios registrados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="row">
        <div class="col-md-12">
            <!-- Título de la página -->
            <h1 class="mb-4 text-center">Usuarios Registrados</h1>

            <div class="text-end mb-3">
                <!-- Botón para agregar nuevo usuario -->
                <a href="agregar-usuario.jsp" class="btn btn-primary">Agregar nuevo Usuario</a>
            </div>

            <%
                List<UsuarioDTO> usuarios = (List<UsuarioDTO>) request.getAttribute("usuarios");
                HttpSession sesion = request.getSession(false);
            %>

            <!-- Mostrar mensaje si no hay usuarios -->
            <% if (usuarios.isEmpty()) { %>
            <p class="text-center">No hay usuarios registrados.</p>
            <% } else { %>

            <!-- Tabla con estilo de Bootstrap -->
            <table class="table table-striped table-bordered text-center">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <% for (UsuarioDTO usuario : usuarios) { %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getUsername() %></td>
                    <td>••••••••</td> <!-- Ocultamos el password para mejorar la seguridad -->

                    <!-- Comprobamos si el usuario tiene permisos para editar/eliminar -->
                    <% if (sesion != null && sesion.getAttribute("usuario") != null) { %>
                    <td>
                        <a href="user?action=editar&id=<%= usuario.getId() %>" class="btn btn-sm btn-warning">Editar ✍️</a>
                        <a href="user?action=eliminar&id=<%= usuario.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">Eliminar 😍️</a>
                    </td>
                    <% } else { %>
                    <td>No tiene permisos para editar o eliminar</td>
                    <% } %>
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

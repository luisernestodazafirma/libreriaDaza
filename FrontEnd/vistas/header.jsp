<%@ page import="com.daza.api.servlet.tarealibreria.dto.UsuarioDTO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title></title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark navbar-expand-lg shadow-sm">
    <div class="container-fluid">
        <!-- Logo de la marca -->
        <a class="navbar-brand fw-bold" href="index.jsp">📚 Libros</a>

        <!-- Botón para dispositivos móviles -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Enlaces de navegación -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="user?action=listar">Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="autor?action=listar">Autores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="libro?action=listar">Libros</a>
                </li>
            </ul>

            <!-- Usuario -->
            <ul class="navbar-nav ms-auto">
                <%
                    UsuarioDTO userr = (UsuarioDTO) session.getAttribute("usuario");
                %>
                <li class="nav-item">
                    <% if (userr != null) { %>
                    <span class="navbar-text me-3">Hola, <strong><%= userr.getUsername() %></strong></span>
                    <a class="btn btn-outline-danger" href="logout">Cerrar Sesión</a>
                    <% } else { %>
                    <a class="btn btn-outline-primary" href="login.jsp">Iniciar Sesión</a>
                    <% } %>
                </li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>

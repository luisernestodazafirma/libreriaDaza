<%@ page import="com.daza.api.servlet.tarealibreria.dto.UsuarioDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="title" content="Sistema de Guardado de Libros">
    <meta name="description" content="Un sistema eficiente para guardar, organizar y gestionar tu colección de libros de forma segura y sencilla.">
    <meta name="keywords" content="libros, sistema de guardado, biblioteca, gestión de libros, colección de libros, organización de libros">
    <meta name="author" content="Daza Firma">
    <meta name="robots" content="index, login">
    <meta name="language" content="Spanish">
    <meta name="theme-color" content="#3E4E5E">
    <meta name="copyright" content="&copy; 2024 Nombre del Desarrollador o Empresa">

    <title>Bienvenido al sistema de libreria</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="font-family: Arial, serif">

<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8 text-center">
            <%
                UsuarioDTO user = (UsuarioDTO) session.getAttribute("usuario");
                HttpSession sesion = request.getSession(false);
            %>

            <!-- Mensaje de bienvenida -->
            <% if (user != null) { %>
            <h1 class="display-4 mb-4">Bienvenido, <%= user.getUsername() %></h1>
            <% } else { %>
            <h1 class="display-4 mb-4">Bienvenido Anónimo</h1>
            <% } %>

            <!-- Botón de cerrar sesión -->
            <% if (sesion != null && sesion.getAttribute("usuario") != null) { %>
            <a href="logout" class="btn btn-outline-danger mb-4">Cerrar Sesión</a>
            <% } %>

            <!-- Texto de la página de bienvenida -->
            <p class="lead mb-4">Este es el contenido de la página de bienvenida.</p>

            <!-- Enlaces en formato de botones -->
            <div class="d-grid gap-2 d-sm-block">
                <a href="autor?action=listar" class="btn btn-primary btn-lg mb-2">Listado de Autores</a>
                <a href="libro?action=listar" class="btn btn-secondary btn-lg mb-2">Listado de Libros</a>
                <a href="user?action=listar" class="btn btn-success btn-lg mb-2">Listado de Usuarios</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<%@ page import="com.daza.api.servlet.tarealibreria.dto.UsuarioDTO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edita un Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<%
    UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("user");
%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Título del formulario -->
            <h1 class="text-center mb-4">Editar Usuario</h1>

            <!-- Formulario estilizado -->
            <form method="post" action="user?action=editar">
                <!-- Campo oculto para el ID del usuario -->
                <input type="hidden" name="id" value="<%= usuario.getId() %>">

                <!-- Campo de nombre de usuario -->
                <div class="form-group">
                    <label for="nombre">Username:</label>
                    <input type="text" class="form-control" name="usuario" id="nombre" value="<%= usuario.getUsername() %>" required>
                </div>

                <!-- Campo de contraseña -->
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" name="password" id="password" value="<%= usuario.getPassword() %>" required>
                </div>

                <!-- Botón para actualizar -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-lg">Actualizar 🤑</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</body>
</html>

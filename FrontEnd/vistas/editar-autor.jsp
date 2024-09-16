<%@ page import="com.daza.api.servlet.tarealibreria.dto.AutorDTO" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edita un autor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<%
    AutorDTO autor = (AutorDTO) request.getAttribute("autor");
%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Título del formulario -->
            <h1 class="text-center mb-4">Editar Autor</h1>

            <!-- Formulario estilizado -->
            <form method="post" action="autor?action=editar">
                <!-- Campo oculto para el ID del autor -->
                <input type="hidden" name="id" value="<%= autor.getId() %>">

                <!-- Campo de nombre del autor -->
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= autor.getNombre() %>" required>
                </div>

                <!-- Campo de nacionalidad -->
                <div class="form-group">
                    <label for="nacionalidad">Nacionalidad:</label>
                    <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" value="<%= autor.getNacionalidad() %>" required>
                </div>

                <!-- Botones de acción -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-primary btn-lg">Actualizar 😁</button>
                    <a href="autor?action=listar" class="btn btn-secondary btn-lg">Cancelar 🤑</a>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>

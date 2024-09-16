<%@ page import="com.daza.api.servlet.tarealibreria.service.AutorService" %>
<%@ page import="com.daza.api.servlet.tarealibreria.service.AutorServiceImp" %>
<%@ page import="com.daza.api.servlet.tarealibreria.dto.AutorDTO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agrega Tus Libros 😍</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<%
    AutorService service = new AutorServiceImp();
%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <!-- Título del formulario -->
            <h1 class="text-center mb-4">Agregar Nuevo Libro</h1>

            <!-- Formulario estilizado -->
            <form method="post" action="libro?action=agregar" enctype="multipart/form-data">
                <!-- Campo de título -->
                <div class="form-group">
                    <label for="titulo">Título</label>
                    <input type="text" class="form-control" id="titulo" name="titulo" required>
                </div>

                <!-- Campo de género -->
                <div class="form-group">
                    <label for="genero">Género</label>
                    <input type="text" class="form-control" id="genero" name="genero" required>
                </div>

                <!-- Campo de número de páginas -->
                <div class="form-group">
                    <label for="numero_paginas">Número de Páginas</label>
                    <input type="number" class="form-control" id="numero_paginas" name="numeroPaginas" required>
                </div>

                <!-- Campo de precio -->
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <input type="number" class="form-control" id="precio" name="precio" step="0.01" required>
                </div>

                <!-- Campo de imagen -->
                <div class="form-group">
                    <label for="imagen">Subir Imagen</label>
                    <input type="file" class="form-control-file" id="imagen" name="imagenPart" accept="image/*" required>
                </div>

                <!-- Campo de selección de autor -->
                <div class="form-group">
                    <label for="autor">Autor</label>
                    <select class="form-control" name="idAutor" id="autor" required>
                        <option value="">Seleccione un autor</option>
                        <%for (AutorDTO autor : service.listaAutores()) {%>
                        <option selected value="<%= autor.getId() %>"><%= autor.getNombre() %></option>
                        <%}%>
                    </select>
                </div>


                <!-- Botón de envío -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-primary btn-lg">Agregar Libro 📙</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>

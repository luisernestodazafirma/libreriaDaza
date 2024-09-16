<%@ page import="com.daza.api.servlet.tarealibreria.dto.LibroDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.daza.api.servlet.tarealibreria.dto.AutorDTO" %>
<%@ page import="com.daza.api.servlet.tarealibreria.service.AutorService" %>
<%@ page import="com.daza.api.servlet.tarealibreria.service.AutorServiceImp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Editar Libro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<%
    LibroDTO libro = (LibroDTO) request.getAttribute("libro");
    AutorService service = new AutorServiceImp();
%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <!-- Título del formulario -->
            <h1 class="text-center mb-4">Editar Libro</h1>

            <!-- Formulario estilizado -->
            <form action="libro?action=editar" method="post" enctype="multipart/form-data">
                <!-- Campo oculto para el ID del libro -->
                <input type="hidden" name="id" value="<%= libro.getId() %>">

                <!-- Campo de título -->
                <div class="form-group">
                    <label for="titulo">Nuevo Título</label>
                    <input type="text" class="form-control" id="titulo" name="titulo" value="<%= libro.getTitulo() %>" required>
                </div>

                <!-- Campo de selección de autor -->
                <div class="form-group">
                    <label for="autor">Nuevo Autor</label>
                    <select class="form-control" name="idAutor" id="autor" required>
                        <option value="">Seleccione un autor</option>
                        <%for (AutorDTO autor : service.listaAutores()) {
                            if (autor.getId() == libro.getIdAutor()) { %>
                        <option selected value="<%= autor.getId() %>"><%= autor.getNombre() %></option>
                        <%} else { %>
                        <option value="<%= autor.getId() %>"><%= autor.getNombre() %></option>
                        <%} } %>
                    </select>
                </div>

                <!-- Campo de género -->
                <div class="form-group">
                    <label for="genero">Nuevo Género</label>
                    <input type="text" class="form-control" id="genero" name="genero" value="<%= libro.getGenero() %>" required>
                </div>

                <!-- Campo de número de páginas -->
                <div class="form-group">
                    <label for="numeroPaginas">Número de Páginas</label>
                    <input type="number" class="form-control" id="numeroPaginas" name="numeroPaginas" value="<%= libro.getNumeroPaginas() %>" required>
                </div>

                <!-- Campo de precio -->
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <input type="number" step="0.01" class="form-control" id="precio" name="precio" value="<%= libro.getPrecio() %>" required>
                </div>

                <!-- Campo de imagen -->
                <div class="form-group">
                    <label for="imagen">Imagen</label>
                    <input type="file" class="form-control-file" id="imagen" name="imagenPart" accept="image/*">
                </div>

                <!-- Botón de actualización -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-lg">Actualizar Libro 📚</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>

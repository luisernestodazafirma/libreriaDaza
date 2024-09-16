<%@ page import="java.util.List" %>
<%@ page import="com.daza.api.servlet.tarealibreria.dto.LibroDTO" %>
<%@ page import="com.daza.api.servlet.tarealibreria.service.AutorService" %>
<%@ page import="com.daza.api.servlet.tarealibreria.service.AutorServiceImp" %>
<%@ page import="com.daza.api.servlet.tarealibreria.dto.AutorDTO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de tus libros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="row">
        <div class="col-md-12">
            <!-- Título de la página -->
            <h1 class="mb-4 text-center">Listado de libros ✍️😍📙</h1>

            <div class="d-flex justify-content-between mb-3">
                <!-- Enlace a la página de inicio -->
                <a href="index.jsp" class="btn btn-secondary">Inicio</a>

                <!-- Botón para agregar nuevo libro -->
                <a href="agregar-libro.jsp" class="btn btn-primary">Agregar nuevo Libro</a>
            </div>

            <%
                List<LibroDTO> libros = (List<LibroDTO>) request.getAttribute("libros");
                HttpSession sesion = request.getSession(false);
                AutorService service = new AutorServiceImp();
            %>

            <!-- Mensaje si no hay libros -->
            <% if (libros.isEmpty()) { %>
            <p class="text-center">No hay libros registrados.</p>
            <% } else { %>

            <!-- Tabla estilizada con Bootstrap -->
            <table class="table table-striped table-bordered text-center">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Género</th>
                    <th>Número de páginas</th>
                    <th>Precio</th>
                    <th>Imagen</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <% for (LibroDTO libro : libros) {
                    byte[] imagenBytes = libro.getImagen();
                    String imagenBase64 = java.util.Base64.getEncoder().encodeToString(imagenBytes);
                %>
                <tr>
                    <td><%= libro.getId() %></td>
                    <td><%= libro.getTitulo() %></td>

                    <!-- Mostrar el nombre del autor -->
                    <% boolean encontro = false;
                        for (AutorDTO autor : service.listaAutores()) {
                            if (autor.getId() == libro.getIdAutor()) {
                                encontro = true; %>
                    <td><%= autor.getNombre() %></td>
                    <% } } if (!encontro) { %>
                    <td>Anónimo</td>
                    <% } %>

                    <td><%= libro.getGenero() %></td>
                    <td><%= libro.getNumeroPaginas() %></td>
                    <td>S/. <%= libro.getPrecio() %></td>

                    <!-- Mostrar imagen -->
                    <td><img src="data:image/jpeg;base64,<%= imagenBase64 %>" alt="Imagen del libro" width="100"/></td>

                    <!-- Acciones: Editar/Eliminar -->
                    <% if (sesion != null && sesion.getAttribute("usuario") != null) { %>
                    <td>
                        <a href="libro?action=editar&id=<%= libro.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                        <a href="libro?action=eliminar&id=<%= libro.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este libro?');">Eliminar</a>
                    </td>
                    <% } else { %>
                    <td>Necesitas iniciar sesión para editar y eliminar libros.</td>
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

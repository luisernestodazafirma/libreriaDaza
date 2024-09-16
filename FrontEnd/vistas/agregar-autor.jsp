<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agrega un autor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Título del formulario -->
            <h1 class="text-center mb-4">Agregar Nuevo Autor</h1>

            <!-- Formulario estilizado -->
            <form method="post" action="autor?action=agregar">
                <!-- Campo de nombre -->
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>

                <!-- Campo de nacionalidad -->
                <div class="form-group">
                    <label for="nacionalidad">Nacionalidad:</label>
                    <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" required>
                </div>

                <!-- Botón de envío -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-primary btn-lg">Registrar Autor ✍️</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>

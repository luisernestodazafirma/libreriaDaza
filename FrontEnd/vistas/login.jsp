<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/415cf7dc20.js" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="estilos/style.css">
    <link rel="shortcut icon" href="imagenes/amazon_icon.png" type="image/x-icon">
    <title>LIBRERIA | LOGIN</title>
</head>
<body>
<jsp:include page="header.jsp" />

<%
    String mensaje = (String) request.getAttribute("error");
    if (mensaje != null) {
%>
<h1 style="color: darkred; font-family: Arial, serif"><%=mensaje%>
</h1>
<%}%>

<section>
    <div class="contenedor">
        <div class="login">
            <form action="login" method="post">
                <h2>INICIAR SESIÓN</h2>

                <div class="input-contenedor">
                    <i class="fa-solid fa-envelope"></i>
                    <input type="text" name="username" id="email" required>
                    <label for="email">Usuario</label>
                </div>

                <div class="input-contenedor">
                    <i class="fa-solid fa-lock"></i>
                    <input type="password" name="password" id="password" required>
                    <label for="password">Contraseña</label>
                </div>

                <button type="submit">Ingresar</button>
            </form>
        </div>
    </div>
</section>

</body>
</html>
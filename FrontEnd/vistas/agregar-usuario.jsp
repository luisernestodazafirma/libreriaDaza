<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/415cf7dc20.js" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="estilos/style.css">
    <title>REGISTRO</title>
</head>
<body>
<jsp:include page="header.jsp" />

<section>
        <div class="contenedor">
            <div class="login">
                <form action="user?action=agregar" method="post">
                    <h2>REGISTRARSE</h2>

                    <div class="input-contenedor">
                        <i class="fa-solid fa-envelope"></i>
                        <input type="text" name="usuario" id="email" required>
                        <label for="email">Usuario</label>
                    </div>

                    <div class="input-contenedor">
                        <i class="fa-solid fa-lock"></i>
                        <input type="password" name="password" id="password" required>
                        <label for="password">Contraseña</label>
                    </div>

                <button type="submit">Crear Usuario 🧑🏽</button>

                </form>

                <div>
                    <div class="registrar">
                        <p>¿Ya tiene una cuenta?<a href="login.jsp">Iniciar Sesión</a></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>

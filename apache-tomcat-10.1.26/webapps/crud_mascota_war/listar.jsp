<%@ page import="java.util.List" %>
<%@ page import="com.daza.api.servlet.crudmascota.model.Mascota" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Mascotas</title>
</head>
<body>
<h1>Listado de Mascotas</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Especie</th>
    </tr>
    <%
        List<Mascota> mascotas = (List<Mascota>) request.getAttribute("mascotas");
        if (mascotas != null) {
            for (Mascota mascota : mascotas) {
    %>
    <tr>
        <td><%= mascota.getId() %></td>
        <td><%= mascota.getNombre() %></td>
        <td><%= mascota.getEspecie() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">No hay mascotas para mostrar.</td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>

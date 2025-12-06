<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, Modelo.Mascota, Modelo.Dueno" %>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Mascotas</title>
</head>

<body>

<h2>Listado de Mascotas</h2>

<a href="MascotaServlet?accion=agregar">Agregar Mascota</a>
<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Especie</th>
        <th>Raza</th>
        <th>Edad</th>
        <th>ID Dueño</th>
        <th>Acciones</th>
    </tr>

    <%
        List<Mascota> lista = (List<Mascota>) request.getAttribute("listaMascotas");

        if (lista != null && !lista.isEmpty()) {
            for (Mascota m : lista) {
    %>

    <tr>
        <td><%= m.getId_mascota() %></td>
        <td><%= m.getNombre() %></td>
        <td><%= m.getEspecie() %></td>
        <td><%= m.getRaza() %></td>
        <td><%= m.getEdad() %></td>
        <td><%= m.getId_dueno() %></td>
        

        <td>
            <a href="MascotaServlet?accion=editar&id=<%= m.getId_mascota() %>">Editar</a>
            |
            <a href="MascotaServlet?accion=eliminar&id=<%= m.getId_mascota() %>"
               onclick="return confirm('¿Seguro que deseas eliminar esta mascota?')">
               Eliminar
            </a>
        </td>
    </tr>

    <%
            }
        } else {
    %>

    <tr>
        <td colspan="7">No hay mascotas registradas.</td>
    </tr>

    <% } %>

</table>

<br>
<a href="menu.jsp">Volver al menú</a>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, Modelo.Dueno" %>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Dueños</title>
</head>

<body>

<h2>Listado de Dueños</h2>


<a href="DuenoServlet?accion=agregar">Agregar Dueño</a>
<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Teléfono</th>
        <th>Dirección</th>
        <th>Acciones</th>
    </tr>

    <%
        // El servlet manda lista como: request.setAttribute("listaDueno", lista);
        List<Dueno> lista = (List<Dueno>) request.getAttribute("listaDueno");

        if (lista != null) {
            for (Dueno d : lista) {
    %>
        <tr>
            <td><%= d.getId_dueno() %></td>
            <td><%= d.getNombre() %></td>
            <td><%= d.getTelefono() %></td>
            <td><%= d.getDireccion() %></td>

            <td>
                <a href="DuenoServlet?accion=editar&id=<%= d.getId_dueno() %>">Editar</a>
                |
                <a href="DuenoServlet?accion=eliminar&id=<%= d.getId_dueno() %>"
                   onclick="return confirm('¿Seguro que deseas eliminar?')">
                   Eliminar
                </a>
            </td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="5">No hay registros.</td>
        </tr>
    <% } %>

</table>
<br>
	<a href="menu.jsp">Volver</a>
</body>
</html>

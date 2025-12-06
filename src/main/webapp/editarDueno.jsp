<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="Modelo.Dueno" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Dueño</title>
</head>

<body>

<%
    Dueno d = (Dueno) request.getAttribute("dueno");
    if (d == null) {
%>
    <h3>Error: No se encontró el dueño.</h3>
    <a href="DuenoServlet?accion=listar">Volver</a>
<%
        return;
    }
%>

<h2>Editar Dueño</h2>

<form action="DuenoServlet?accion=actualizar" method="post">

    <!-- ID Oculto -->
    <input type="hidden" name="idDueno" value="<%= d.getId_dueno() %>">

    Nombre: <br>
    <input type="text" name="nombre" value="<%= d.getNombre() %>" required><br><br>

    Teléfono: <br>
    <input type="text" name="telefono" value="<%= d.getTelefono() %>" required><br><br>

    Dirección: <br>
    <input type="text" name="direccion" value="<%= d.getDireccion() %>" required><br><br>

    <button type="submit">Actualizar</button>
</form>

<br>
<a href="DuenoServlet?accion=listar">Volver</a>

</body>
</html>

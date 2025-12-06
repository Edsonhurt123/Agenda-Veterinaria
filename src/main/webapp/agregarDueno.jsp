<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, Modelo.Dueno" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Dueño</title>
</head>

<body>

<h2>Agregar Dueño</h2>

<!-- Debe enviarse accion=guardar -->
<form action="DuenoServlet?accion=guardar" method="post">

    Nombre: <br>
    <input type="text" name="nombre" required><br><br>

    Teléfono: <br>
    <input type="text" name="telefono" required><br><br>

    Dirección: <br>
    <input type="text" name="direccion" required><br><br>

    <button type="submit">Guardar</button>
</form>

<br>
<a href="DuenoServlet?accion=listar">Volver</a>

</body>
</html>

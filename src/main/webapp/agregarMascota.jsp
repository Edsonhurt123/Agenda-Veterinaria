<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, Modelo.Dueno" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Mascota</title>
</head>
<body>

<h2>Agregar Mascota</h2>

<form action="MascotaServlet" method="post">
    <input type="hidden" name="accion" value="guardar">

    <label>Nombre:</label><br>
    <input type="text" name="nombre" required><br><br>

    <label>Especie:</label><br>
    <input type="text" name="especie" required><br><br>

    <label>Raza:</label><br>
    <input type="text" name="raza"><br><br>

    <label>Edad:</label><br>
    <input type="number" name="edad" min="0" required><br><br>

    <label>Dueño:</label><br>
    <select name="id_dueno" required>
        <option value="">-- Seleccione un dueño --</option>

        <%
            List<Dueno> lista = (List<Dueno>) request.getAttribute("listaDueno");
            if (lista != null) {
                for (Dueno d : lista) {
        %>
                    <option value="<%= d.getId_dueno() %>">
                        <%= d.getNombre() %>
                    </option>
        <%
                }
            }
        %>
    </select>
    <br><br>

    <button type="submit">Guardar</button>
</form>

<br>
<a href="MascotaServlet?accion=listar">Volver a la lista</a><br>
<a href="menu.jsp">Volver al menú</a>

</body>
</html>

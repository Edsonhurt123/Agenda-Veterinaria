<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, Modelo.Dueno, Modelo.Mascota" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Mascota</title>
</head>
<body>

<h2>Editar Mascota</h2>

<%
    Mascota m = (Mascota) request.getAttribute("mascota");
    List<Dueno> lista = (List<Dueno>) request.getAttribute("listaDueno");
%>

<form action="MascotaServlet" method="post">
    <input type="hidden" name="accion" value="actualizar">
    <input type="hidden" name="id" value="<%= m.getId_mascota() %>">

    <label>Nombre:</label><br>
    <input type="text" name="nombre" value="<%= m.getNombre() %>" required><br><br>

    <label>Especie:</label><br>
    <input type="text" name="especie" value="<%= m.getEspecie() %>" required><br><br>

    <label>Raza:</label><br>
    <input type="text" name="raza" value="<%= m.getRaza() %>"><br><br>

    <label>Edad:</label><br>
    <input type="number" name="edad" min="0" value="<%= m.getEdad() %>" required><br><br>

    <label>Dueño:</label><br>
    <select name="id_dueno" required>
        <option value="">-- Seleccione un dueño --</option>

        <%
            if (lista != null) {
                for (Dueno d : lista) {
        %>
                    <option value="<%= d.getId_dueno() %>"
                        <%= (d.getId_dueno() == m.getId_dueno() ? "selected" : "") %>>
                        <%= d.getNombre() %>
                    </option>
        <%
                }
            }
        %>
    </select>

    <br><br>

    <button type="submit">Actualizar</button>
</form>

<br>
<a href="MascotaServlet?accion=listar">Volver a la lista</a><br>
<a href="menu.jsp">Volver al menú</a>

</body>
</html>
>
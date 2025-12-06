<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menú Principal - Veterinaria</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 30px;
            width: 350px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.15);
        }

        h1 {
            margin-top: 0;
            color: #333;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        ul li {
            margin: 12px 0;
        }

        a {
            text-decoration: none;
            background: #4CAF50;
            color: white;
            padding: 10px 15px;
            display: block;
            border-radius: 5px;
            transition: 0.2s;
        }

        a:hover {
            background: #45a049;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Menú Principal</h1>
    <p>Selecciona una opción:</p>

    <ul>
        <li><a href="DuenoServlet?accion=listar">Gestión de Dueños</a></li>
        <li><a href="MascotaServlet?accion=listar">Gestión de Mascotas</a></li>
        <li><a href="VeterinarioServlet?accion=listar">Gestión de Veterinarios</a></li>
        <li><a href="CitaServlet?accion=listar">Gestión de Citas</a></li>
    </ul>
</div>

</body>
</html>

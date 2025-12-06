package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Modelo.Dueno;
import DAO.DuenoDAO;

@WebServlet("/DuenoServlet")
public class DuenoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        DuenoDAO dao = new DuenoDAO();

        if (accion == null) accion = "listar";

        switch (accion) {

            case "agregar":   // ← FALTABA ESTE CASE
                request.getRequestDispatcher("agregarDueno.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Dueno d = dao.obtenerPorId(idEditar);
                request.setAttribute("dueno", d);
                request.getRequestDispatcher("editarDueno.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("DuenoServlet?accion=listar");
                break;

            case "listar":
            default:
                List<Dueno> lista = dao.listar();
                request.setAttribute("listaDueno", lista);
                request.getRequestDispatcher("duenos.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        DuenoDAO dao = new DuenoDAO();

        if (accion == null) accion = "guardar";

        switch (accion) {

            case "guardar":   // ← INSERTAR NUEVO
                Dueno nuevo = new Dueno();
                nuevo.setNombre(request.getParameter("nombre"));
                nuevo.setTelefono(request.getParameter("telefono"));
                nuevo.setDireccion(request.getParameter("direccion"));
                dao.insertar(nuevo);
                break;

            case "actualizar":   // ← EDITAR EXISTENTE
                Dueno actualizado = new Dueno();
                actualizado.setId_dueno(Integer.parseInt(request.getParameter("idDueno")));
                actualizado.setNombre(request.getParameter("nombre"));
                actualizado.setTelefono(request.getParameter("telefono"));
                actualizado.setDireccion(request.getParameter("direccion"));
                dao.actualizar(actualizado);
                break;
        }

        response.sendRedirect("DuenoServlet?accion=listar");
    }
}

package Controlador;

import Modelo.Mascota;
import DAO.MascotaDAO;
import DAO.DuenoDAO;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MascotaServlet")
public class MascotaServlet extends HttpServlet {

    MascotaDAO dao = new MascotaDAO();
    DuenoDAO daoDueno = new DuenoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) accion = "listar";

        switch (accion) {

            case "agregar":
                request.setAttribute("listaDueno", daoDueno.listar());
                request.getRequestDispatcher("agregarMascota.jsp").forward(request, response);
                break;

            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("mascota", dao.obtener(id));
                request.setAttribute("listaDueno", daoDueno.listar());
                request.getRequestDispatcher("editarMascota.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("MascotaServlet?accion=listar");
                break;

            case "listar":
            default:
                request.setAttribute("listaMascotas", dao.listar());
                request.getRequestDispatcher("listarMascota.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {

            case "guardar":
                Mascota m = new Mascota();
                m.setNombre(request.getParameter("nombre"));
                m.setEspecie(request.getParameter("especie"));
                m.setRaza(request.getParameter("raza"));
                m.setEdad(Integer.parseInt(request.getParameter("edad")));
                m.setId_dueno(Integer.parseInt(request.getParameter("id_dueno")));
                dao.agregar(m);
                break;

            case "actualizar":
                Mascota m2 = new Mascota();
                m2.setId_mascota(Integer.parseInt(request.getParameter("id")));
                m2.setNombre(request.getParameter("nombre"));
                m2.setEspecie(request.getParameter("especie"));
                m2.setRaza(request.getParameter("raza"));
                m2.setEdad(Integer.parseInt(request.getParameter("edad")));
                m2.setId_dueno(Integer.parseInt(request.getParameter("id_dueno")));
                dao.actualizar(m2);
                break;
        }

        response.sendRedirect("MascotaServlet?accion=listar");
    }
}

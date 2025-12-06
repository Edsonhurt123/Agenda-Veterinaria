package DAO;

import Modelo.Dueno;
import Repositorio.ConexionBDVeterinara;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    ConexionBDVeterinara cn = new ConexionBDVeterinara();

    // -------------------------------
    // LISTAR TODOS
    // -------------------------------
    public List<Dueno> listar() {
        List<Dueno> lista = new ArrayList<>();
        String sql = "SELECT * FROM dueno";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Dueno d = new Dueno(
                        rs.getInt("id_dueno"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
                lista.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarTodo();
        }

        return lista;
    }

    // -------------------------------
    // INSERTAR
    // -------------------------------
    public boolean insertar(Dueno d) {
        String sql = "INSERT INTO dueno (nombre, telefono, direccion) VALUES (?, ?, ?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getTelefono());
            ps.setString(3, d.getDireccion());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarTodo();
        }

        return false;
    }

    // -------------------------------
    // OBTENER POR ID
    // -------------------------------
    public Dueno obtenerPorId(int id) {
        Dueno d = null;
        String sql = "SELECT * FROM dueno WHERE id_dueno = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                d = new Dueno(
                        rs.getInt("id_dueno"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarTodo();
        }

        return d;
    }

    // -------------------------------
    // ACTUALIZAR
    // -------------------------------
    public boolean actualizar(Dueno d) {
        String sql = "UPDATE dueno SET nombre = ?, telefono = ?, direccion = ? WHERE id_dueno = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, d.getNombre());
            ps.setString(2, d.getTelefono());
            ps.setString(3, d.getDireccion());
            ps.setInt(4, d.getId_dueno());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarTodo();
        }

        return false;
    }

    // -------------------------------
    // ELIMINAR
    // -------------------------------
    public boolean eliminar(int id) {
        String sql = "DELETE FROM dueno WHERE id_dueno = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarTodo();
        }

        return false;
    }

    // -------------------------------
    // CERRAR TODO
    // -------------------------------
    private void cerrarTodo() {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
}

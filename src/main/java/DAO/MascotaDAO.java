package DAO;

import Repositorio.ConexionBDVeterinara;
import Modelo.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

	ConexionBDVeterinara cn = new ConexionBDVeterinara();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Mascota> listar() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascota";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId_mascota(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setId_dueno(rs.getInt("id_dueno"));
                lista.add(m);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return lista;
    }

    public boolean agregar(Mascota m) {
        String sql = "INSERT INTO mascota(nombre, especie, raza, edad, id_dueno) VALUES (?,?,?,?,?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, m.getId_dueno());

            ps.executeUpdate();
            return true;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    public Mascota obtener(int id) {
        Mascota m = new Mascota();
        String sql = "SELECT * FROM mascota WHERE id_mascota=?";

        try {
            con = ConexionBDVeterinara.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                m.setId_mascota(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setId_dueno(rs.getInt("id_dueno"));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return m;
    }

    public boolean actualizar(Mascota m) {
        String sql = "UPDATE mascota SET nombre=?, especie=?, raza=?, edad=?, id_dueno=? WHERE id_mascota=?";

        try {
            con = ConexionBDVeterinara.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, m.getId_dueno());
            ps.setInt(6, m.getId_mascota());

            ps.executeUpdate();
            return true;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mascota WHERE id_mascota=?";

        try {
            con = ConexionBDVeterinara.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }
}

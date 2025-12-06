package Repositorio;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection con = ConexionBDVeterinara .getConexion();
        if (con != null) {
            System.out.println("Conectado correctamente a la BD.");
            ConexionBDVeterinara.cerrarConexion();
        } else {
            System.out.println("No se pudo conectar a la BD.");
        }
    }
}

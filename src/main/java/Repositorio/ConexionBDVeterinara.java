package Repositorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBDVeterinara {

	    private static final String URL = "jdbc:mysql://localhost:3306/veterinaria";
	    private static final String USUARIO = "root"; 
	    private static final String PASSWORD = "admin123";      

	    private static Connection conexion = null;

	    public static Connection getConexion() {
	        try {
	            if (conexion == null || conexion.isClosed()) {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
	                System.out.println("Conexión exitosa a la base de datos.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error de conexión a la base de datos: " + e.getMessage());
	        } catch (ClassNotFoundException e) {
	            System.out.println("No se encontró el driver de MySQL: " + e.getMessage());
	        }
	        return conexion;
	    }

	    public static void cerrarConexion() {
	        try {
	            if (conexion != null && !conexion.isClosed()) {
	                conexion.close();
	                System.out.println("Conexión cerrada correctamente.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar la conexión: " + e.getMessage());
	        }
	    }
	}



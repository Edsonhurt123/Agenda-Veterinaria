package Modelo;

public class Dueno {
    
    // Atributos
    private int id_dueno;
    private String nombre;
    private String telefono;
    private String direccion;

    // Constructor vacío (NECESARIO para el DAO)
    public Dueno() {
    }

    // Constructor con parámetros 
    public Dueno(int id_dueno, String nombre, String telefono, String direccion) {
        this.id_dueno = id_dueno;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getId_dueno() {
        return id_dueno;
    }

    public void setId_dueno(int id_dueno) {
        this.id_dueno = id_dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

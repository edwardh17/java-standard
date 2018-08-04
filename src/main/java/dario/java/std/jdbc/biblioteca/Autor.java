package dario.java.std.jdbc.biblioteca;

public class Autor extends Entidad {
    
    private String nombre;
    private String apellido;
    private String nacionalidad;

    public Autor(Integer id, String nombre, String apellido, String nacionalidad) {
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    public Autor(String nombre, String apellido, String nacionalidad) {
        super(null);
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + getId() + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
    
}

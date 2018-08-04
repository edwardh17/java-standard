package dario.java.std.jdbc.biblioteca;

public class Editorial extends Entidad {
    
    private String nombre;
    private String pais;

    public Editorial(Integer id, String nombre, String pais) {
        super(id);
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}

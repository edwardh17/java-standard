package dario.java.std.jdbc.biblioteca;

public abstract class Entidad {
    
    private Integer id;

    public Entidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
}

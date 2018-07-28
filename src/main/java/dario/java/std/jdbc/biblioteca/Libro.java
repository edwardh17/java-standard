package dario.java.std.jdbc.biblioteca;

public class Libro {

    private Integer id;
    private String titulo;
    private String editorial;
    private Autor autor;

    public Libro(Integer id, String titulo, String editorial, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro(String titulo, String editorial, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
    
}

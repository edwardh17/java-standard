package dario.java.std.jdbc.biblioteca;

public class Libro extends Entidad {

    private String titulo;
    private Editorial editorial;
    private Autor autor;

    public Libro(Integer id, String titulo, Editorial editorial, Autor autor) {
        super(id);
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro(String titulo, Editorial editorial, Autor autor) {
        super(null);
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", editorial=" + editorial + ", autor=" + autor + '}';
    }
    
    
    
}

package dario.java.std.jdbc.biblioteca;

public class Biblioteca {

    
    public static void main(String[] args) {
        AutorDao autorDao = new JdbcAutorDao();
        EditorialDao editorialDao = new JdbcEditorialDao();
        LibroDao libroDao = new JdbcLibroDao(editorialDao, autorDao);
        
        Autor cortazar = new Autor("Julio", "Cortazar", "Argentina");
        Autor borges = new Autor("Jorge Luis", "Borges", "Argentina");       
        cortazar = autorDao.grabar(cortazar);
        borges = autorDao.grabar(borges);
        
        Editorial planeta = new Editorial("planeta", "España");
        planeta = editorialDao.grabar(planeta);
        
        Libro rayuela = new Libro("Rayuela", planeta, cortazar);
        Libro elAleph = new Libro("El Aleph", planeta, borges);
        
        libroDao.grabar(rayuela);
        libroDao.grabar(elAleph);
        
        libroDao.traerTodos().forEach(System.out::println);
     
    }

    
}

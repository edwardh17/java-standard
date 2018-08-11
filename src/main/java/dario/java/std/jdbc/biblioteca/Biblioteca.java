package dario.java.std.jdbc.biblioteca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Biblioteca {
    
    private static final Logger logger = LoggerFactory.getLogger(Biblioteca.class);
    
    public static void main(String[] args) {
        AutorDao autorDao = new JdbcAutorDao();
        EditorialDao editorialDao = new JdbcEditorialDao();
        LibroDao libroDao = new JdbcLibroDao(editorialDao, autorDao);
        
        Autor cortazar = new Autor("Julio", "Cortazar", "Argentina");
        Autor borges = new Autor("Jorge Luis", "Borges", "Argentina");       
        cortazar = autorDao.grabar(cortazar);
        logger.info("guardando cortazar");
        borges = autorDao.grabar(borges);
        logger.info("guardando borges");

        
        Editorial planeta = new Editorial("planeta", "España");
        planeta = editorialDao.grabar(planeta);
        logger.info("guardando planeta");
        
        Libro rayuela = new Libro("Rayuela", planeta, cortazar);
        Libro elAleph = new Libro("El Aleph", planeta, borges);
        
        libroDao.grabar(rayuela);
        logger.info("guardando rayuela");

        libroDao.grabar(elAleph);
        logger.info("guardando el Aleph");
        
        libroDao.traerTodos().forEach(l -> logger.info(l.toString()));
     
    }

    
}

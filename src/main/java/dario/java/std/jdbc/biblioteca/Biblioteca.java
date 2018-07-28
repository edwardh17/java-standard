package dario.java.std.jdbc.biblioteca;

public class Biblioteca {

    
    public static void main(String[] args) {
        AutorDao autorDao = new JdbcAutorDao();
        
        Autor autor1 = new Autor("Julio", "Cortazar", "Argentina");
        Autor autor2 = new Autor("Jorge Luis", "Borges", "Argentina");
        
        autorDao.grabar(autor1);
        autorDao.grabar(autor2);
        
        autorDao.traerTodos().forEach(System.out::println);
        
        
                
                
    }

    
}

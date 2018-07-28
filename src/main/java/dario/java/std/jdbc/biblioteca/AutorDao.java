package dario.java.std.jdbc.biblioteca;

import java.util.List;

public interface AutorDao {

    Autor grabar(Autor autor);
    void actualizar(Autor autor);
    Autor borrar(Integer id);
    List<Autor> traerTodos();
    Autor traerPorId(Integer id);
}

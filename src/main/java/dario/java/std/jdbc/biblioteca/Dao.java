package dario.java.std.jdbc.biblioteca;

import java.util.List;

public interface Dao<T extends Entidad> {
    
    T grabar(T e);
    void actualizar(T e);
    void borrar(Integer id);
    List<T> traerTodos();
    T traerPorId(Integer id);
    
}

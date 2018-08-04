package dario.java.std.jdbc.biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcLibroDao extends SoporteDao<Libro> implements LibroDao {
    
    private EditorialDao editorialDao;
    private AutorDao autorDao;

    public JdbcLibroDao(EditorialDao editorialDao, AutorDao autorDao) {
        this.editorialDao = editorialDao;
        this.autorDao = autorDao;
    }        
            
    @Override
    protected String generarSqlGrabar() {
        return "insert into libro (titulo, idEditorial, idAutor) values (?,?,?)";
    }

    @Override
    protected String obtenerSqlActualizar() {
        return "update libro set titulo = ?, idEditorial=?, idAutor=? where id = ?";
    }

    @Override
    protected String obtenerNombreTabla() {
        return "libro";
    }

    @Override
    protected Libro crearEntidad(ResultSet rs) throws SQLException {
        Integer idEditorial = rs.getInt("idEditorial");
        Editorial editorial = editorialDao.traerPorId(idEditorial);
        Integer idAutor = rs.getInt("idAutor");
        Autor autor = autorDao.traerPorId(idAutor);
        Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), editorial, autor);
        return libro;
    }

    @Override
    protected Map<Integer, Object> obtenerParametros(Libro e) {
        Map<Integer, Object> parametros =new HashMap<>();
        parametros.put(1, e.getTitulo());
        parametros.put(2, e.getEditorial().getId());
        parametros.put(3, e.getAutor().getId());
        return parametros;
    }
    
}

package dario.java.std.jdbc.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcEditorialDao 
        extends SoporteDao<Editorial> 
        implements EditorialDao {

    @Override
    protected String obtenerSqlActualizar() {
        return "update editorial set nombre=?, pais=? where id=?";
    }
    
    @Override
    protected String generarSqlGrabar() {
        return "insert into editorial (nombre, pais) values (?,?)";
    }

    @Override
    protected String obtenerNombreTabla() {
        return "editorial";
    }

    @Override
    protected Editorial crearEntidad(ResultSet rs) throws SQLException {
        return new Editorial(rs.getInt("id"),
                rs.getString("nombre"), rs.getString("pais"));
    }

    @Override
    protected Map<Integer, Object> obtenerParametros(Editorial e) {
        Map<Integer, Object> parametros = new HashMap<>();
        parametros.put(1, e.getNombre());
        parametros.put(2, e.getPais());
        return parametros;
    }
    
}

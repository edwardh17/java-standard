package dario.java.std.jdbc.biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcAutorDao extends SoporteDao<Autor> implements AutorDao {

    @Override
    protected String generarSqlGrabar() {
        return "insert into autor (nombre, apellido, nacionalidad) "
                    + " values (?, ?, ?)";
    }

    @Override
    protected String obtenerSqlActualizar() {
        return "update autor set nombre = ?, apellido = ?, nacionalidad = ? where id = ?";
    }

    @Override
    protected String obtenerNombreTabla() {
        return "autor";
    }

    @Override
    protected Autor crearEntidad(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String nacionalidad = rs.getString("nacionalidad");
        return new Autor(id, nombre, apellido, nacionalidad);
    }

    @Override
    protected Map<Integer, Object> obtenerParametros(Autor e) {
        Map<Integer, Object> parametros = new HashMap<>();
        parametros.put(1,e.getNombre());
        parametros.put(1,e.getApellido());
        parametros.put(3,e.getNacionalidad());
        return parametros;
    }
    
}

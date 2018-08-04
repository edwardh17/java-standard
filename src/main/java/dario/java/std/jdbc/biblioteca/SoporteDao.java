package dario.java.std.jdbc.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SoporteDao<T extends Entidad> implements Dao<T> {

    @Override
    public T grabar(T e) {
        try {
            String sql = generarSqlGrabar();
            PreparedStatement stmt = obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            Map<Integer, Object> parametros = obtenerParametros(e);
            parametros.forEach((k,v) -> {
                try {
                    if (v instanceof Integer) {                    
                        stmt.setInt(k, (Integer)v);
                    } else if (v instanceof String) {
                        stmt.setString(k, (String)v);
                    }
                } catch (SQLException ex) {
                    getLogger().log(Level.SEVERE, null, ex);
                }
            });
            
            ejecutarActualizacion(stmt);
            
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                e.setId(generatedKey.getInt(1));
            }
            
            return e;
        } catch (SQLException ex) {
            getLogger().log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void actualizar(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> traerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T traerPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void ejecutarActualizacion(PreparedStatement stmt) throws SQLException {
        int rows = stmt.executeUpdate();
        getLogger().log(Level.INFO, "Registros modificados: "+rows);
    }

    protected abstract Logger getLogger();
    protected abstract String generarSqlGrabar();
    protected abstract Connection obtenerConexion();
    protected abstract Map<Integer, Object> obtenerParametros(T e);
    
}

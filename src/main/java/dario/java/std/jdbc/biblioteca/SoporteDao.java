package dario.java.std.jdbc.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SoporteDao<T extends Entidad> implements Dao<T> {
    
    private static Logger logger = Logger.getLogger(SoporteDao.class.getName());

    @Override
    public T grabar(T e) {
        try {
            String sql = generarSqlGrabar();
            PreparedStatement stmt = obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            setearParametros(obtenerParametros(e), stmt);
                        
            ejecutarActualizacion(stmt);
            
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                e.setId(generatedKey.getInt(1));
            }
            
            return e;
        } catch (SQLException ex) {            
            throw new AccedoDeDatosException(ex);
        }
    }

    @Override
    public void actualizar(T e) {
        try {
            String sql = obtenerSqlActualizar();

            PreparedStatement stmt = obtenerConexion().prepareStatement(sql);
            Map<Integer, Object> parametros = obtenerParametros(e);
            setearParametros(parametros, stmt);
            stmt.setInt(parametros.size()+1, e.getId());
            
            ejecutarActualizacion(stmt);
        } catch (SQLException ex) {
            throw new AccedoDeDatosException(ex);
        }    }

    @Override
    public void borrar(Integer id) {
        try {
            String sql = "delete from "+obtenerNombreTabla() + " where id="+id;

            Statement stmt = obtenerConexion().createStatement();
            //stmt.setInt(1, id);
            
            //ejecutarActualizacion(stmt);
            stmt.execute(sql);
        } catch (SQLException ex) {
            throw new AccedoDeDatosException(ex);
        }
    }

    @Override
    public List<T> traerTodos() {
        try {
            String sql = "select * from "+obtenerNombreTabla();
            Statement stmt = obtenerConexion().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            List<T> entidades = new ArrayList<>();
            
            while (rs.next()) {                
                entidades.add(crearEntidad(rs));
            }
            
            return entidades;
        } catch (SQLException ex) {
            throw new AccedoDeDatosException(ex);
        }
    }

    @Override
    public T traerPorId(Integer id) {
        try {
            String sql = "select * from "+obtenerNombreTabla() + " where id="+id;

            Statement stmt = obtenerConexion().createStatement();
            //stmt.setInt(1, id);
            
            //ejecutarActualizacion(stmt);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            T entidad = null;
                
            if (rs.next()) {                
                entidad = crearEntidad(rs);
            }
            
            return entidad;
        } catch (SQLException ex) {
            throw new AccedoDeDatosException(ex);
        }
    }
    
    private void ejecutarActualizacion(PreparedStatement stmt) throws SQLException {
        int rows = stmt.executeUpdate();
        getLogger().log(Level.INFO, "Registros modificados: "+rows);
    }
    
    private void setearParametros(Map<Integer, Object> parametros, PreparedStatement stmt) {
        parametros.forEach((k,v) -> {
            try {
                if (v instanceof Integer) {                    
                    stmt.setInt(k, (Integer)v);
                } else if (v instanceof String) {
                    stmt.setString(k, (String)v);
                }
            } catch (SQLException ex) {
                throw new AccedoDeDatosException(ex);
            }
        });
    }
    
    protected Connection obtenerConexion() {
        return AdministradorDeConexiones.getInstancia().getConnection();
    }

    protected Logger getLogger() {
        return logger;
    }    
    protected abstract String generarSqlGrabar();
    protected abstract String obtenerSqlActualizar();
    protected abstract String obtenerNombreTabla();
    
    protected abstract T crearEntidad(ResultSet rs) throws SQLException;
    protected abstract Map<Integer, Object> obtenerParametros(T e);
    
}

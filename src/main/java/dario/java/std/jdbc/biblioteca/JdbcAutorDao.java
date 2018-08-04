package dario.java.std.jdbc.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcAutorDao implements AutorDao {

    private static Logger logger = Logger.getLogger(JdbcAutorDao.class.getName());
    private Connection connection;
    
    public JdbcAutorDao() {
        try {
            String usuario = "root";
            String clave = "";
            String stringConection = "jdbc:mysql://localhost:3306/biblioteca";
            connection = DriverManager.getConnection(stringConection, usuario, clave);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Autor grabar(Autor autor) {
        try {
            String sql =  "insert into autor (nombre, apellido, nacionalidad) "
                    + " values (?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getApellido());
            stmt.setString(3, autor.getNacionalidad());
            
            ejecutarActualizacion(stmt);
            
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                autor.setId(generatedKey.getInt(1));
            }
            
            return autor;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }

    @Override
    public void actualizar(Autor autor) {
        try {
            String sql = "update autor set nombre = ?, apellido = ?, nacionalidad = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getApellido());
            stmt.setString(3, autor.getNacionalidad());
            stmt.setInt(4, autor.getId());
            
            ejecutarActualizacion(stmt);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(Integer id) {
        try {
            String sql = "delete from autor where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ejecutarActualizacion(stmt);
            
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Autor> traerTodos() {
        try {
            String sql = "select id,nombre,apellido,nacionalidad from autor";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            List<Autor> autores = new ArrayList<>();
            
            while (rs.next()) {                
                autores.add(crearAutor(rs));
            }
            
            return autores;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Autor traerPorId(Integer id) {
        try {
            String sql = "select id,nombre,apellido,nacionalidad from autor where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Autor autor = null;
            
            if (rs.next()) {
                autor = crearAutor(rs);
            }
                        
            return autor;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    private Autor crearAutor(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String nacionalidad = rs.getString("nacionalidad");
        return new Autor(id, nombre, apellido, nacionalidad);
    }
    
    private void ejecutarActualizacion(PreparedStatement stmt) throws SQLException {
        int rows = stmt.executeUpdate();
        logger.log(Level.INFO, "Registros modificados: "+rows);
    }
    
}

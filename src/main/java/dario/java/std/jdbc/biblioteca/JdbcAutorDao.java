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
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getApellido());
            stmt.setString(3, autor.getNacionalidad());
            
            int rows = stmt.executeUpdate();
            logger.log(Level.INFO, "Rows:"+rows);
            //TODO: Setear id al autor
            
            return autor;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }

    @Override
    public void actualizar(Autor autor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Autor borrar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
}

package dario.java.std.jdbc;

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

public class JdbcMain {
    
    //https://github.com/dhruszecki/java-standard


    public static void main(String[] args) {

        try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bair", "root", "")) {
                                    
            LugarDAO dao = new LugarDAOImpl();
            
            Lugar lugar = new Lugar(6,"Diego", "Florida 222", "tp link");
            
            dao.grabar(conexion, lugar);
            
            lugar.setNombreResponsable("Leo");
            
            dao.actualizar(conexion, lugar);
            
            dao.borrar(conexion, lugar);
            
            dao.obtenerTodos(conexion).forEach(System.out::println);
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}

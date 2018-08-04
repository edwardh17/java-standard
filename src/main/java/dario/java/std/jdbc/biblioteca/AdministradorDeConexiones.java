package dario.java.std.jdbc.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {

    
    private static AdministradorDeConexiones instancia;
    
    private Connection connection;
    
    private AdministradorDeConexiones() {
        try {
            String usuario = "root";
            String clave = "";
            String stringConection = "jdbc:mysql://localhost:3306/biblioteca";
            connection = DriverManager.getConnection(stringConection, usuario, clave);
        } catch (SQLException ex) {
            throw new AccedoDeDatosException(ex);
        }
    }    
    
    public synchronized static AdministradorDeConexiones getInstancia() {
        
        if (instancia==null) {
            instancia = new AdministradorDeConexiones();
        }

        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }
    
}

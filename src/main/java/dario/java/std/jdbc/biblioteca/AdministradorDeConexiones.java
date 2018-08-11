package dario.java.std.jdbc.biblioteca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {

    private final Logger logger = LoggerFactory.getLogger(AdministradorDeConexiones.class);


    private static AdministradorDeConexiones instancia;

    private Connection connection;
    
    private AdministradorDeConexiones() {
        try {
            Configuracion configuracion = new Configuracion();
            String usuario = configuracion.getDBUser();
            String clave = configuracion.getDBPassword();
            String stringConection = configuracion.getDatabase();
            connection = DriverManager.getConnection(stringConection, usuario, clave);
        } catch (SQLException ex) {
            logger.error("Error conectandose a la bd", ex);
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

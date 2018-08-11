package dario.java.std.jdbc.biblioteca;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuracion {

    private final Logger logger = LoggerFactory.getLogger(Configuracion.class);

    private static Configuracion instancia;
    
    private Properties properties;
    
    public synchronized static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }
    
    private Configuracion() {
        properties = new  Properties();
        InputStream input = null;

        try {

            input = getClass().getResourceAsStream("/config.properties");

            // load a properties file
            properties.load(input);


        } catch (IOException ex) {
            logger.error("error al cargar configuracion",ex);
            throw new RuntimeException(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("error al cargar configuracion",e);
                }
            }
        }
    }

    public String getDatabase() {
        return properties.getProperty("database");
    }

    public String getDBUser() {
        return properties.getProperty("dbuser");
    }

    public String getDBPassword() {
        return properties.getProperty("dbpassword");
    }
}

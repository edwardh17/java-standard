package dario.java.std.jdbc.biblioteca;

import java.sql.SQLException;

public class AccedoDeDatosException extends RuntimeException {

    public AccedoDeDatosException(SQLException ex) {
        super(ex);
    }
    
}

package dario.java.std.jdbc.biblioteca;

import java.sql.SQLException;

public class LecturaDeDatosException extends RuntimeException {

    public LecturaDeDatosException(SQLException ex) {
        super(ex);
    }
    
}

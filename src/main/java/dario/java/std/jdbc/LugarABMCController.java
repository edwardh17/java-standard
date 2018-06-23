package dario.java.std.jdbc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class LugarABMCController implements Initializable {
    
    private LugarDAO dao;
    private Connection connection;
    
    @FXML
    private TextField idTxt;

    @FXML
    private TextField txtDireccion;

    @FXML
    private ListView<Lugar> listLugares;
    
    private ObservableList<Lugar> lugares;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnCancelar;
    
    @FXML
    private Button btnBorrar;

    @FXML
    private TextField txtRouter;

    @FXML
    private Button btnGrabar;

    @FXML
    private TextField txtResponsable;

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void nuevo(ActionEvent event) {


    }

    @FXML
    void grabar(ActionEvent event) {
        try {
            Lugar nuevo = new Lugar (txtResponsable.getText(), txtDireccion.getText(),
                    txtRouter.getText());
            lugares.add(dao.grabar(connection, nuevo));
        } catch (SQLException ex) {
            Logger.getLogger(LugarABMCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void borrar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dao = new LugarDAOImpl();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bair", "root", "");
            lugares =FXCollections.observableArrayList (dao.obtenerTodos(connection));
            listLugares.getItems().addAll(lugares);
        } catch (SQLException ex) {
            Logger.getLogger(LugarABMCController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }    
    
}

package dario.java.std.texteditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;


public class TextEditorPantallaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    @FXML
    private MenuItem menuItemSave;
    
    @FXML
    private MenuItem menuItemOpen;
    
    @FXML
    private TextArea texto;
    
    
    private File currentFile;

    @FXML
    void openFileAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file ...");
        currentFile = fileChooser.showOpenDialog(menuItemOpen.getParentPopup().getScene().getWindow());
        
        
        if (currentFile!=null) {
            try (FileReader reader = new FileReader(currentFile); 
                    BufferedReader buffer = new BufferedReader(reader)) {
              
              String linea;
              while ((linea=buffer.readLine()) != null)                 
                texto.appendText(linea + "\r\n");
                                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextEditorPantallaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TextEditorPantallaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @FXML
    void saveFileAction(ActionEvent event) {
        //char[] charsToSave = texto.getText().toCharArray();
        
        try (FileWriter writer = new FileWriter(currentFile);
                BufferedWriter buffer = new BufferedWriter(writer);
                Reader reader = new StringReader(texto.getText());
                BufferedReader bufferedReader = new BufferedReader(reader)) {
                
                String linea;
                while ((linea=bufferedReader.readLine()) != null) {                 
                    buffer.write(linea);
                    buffer.newLine();
                }
                
        } catch (IOException ex) {
            Logger.getLogger(TextEditorPantallaController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}

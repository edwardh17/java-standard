package dario.java.std.texteditor;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TextEditor extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root =  FXMLLoader.load(getClass()
                .getClassLoader().getResource("fxml/TextEditorPantalla.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("TextEditor 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

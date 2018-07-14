package dario.java.std.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraArchivosTexto {

    public static void main(String[] args) {
        String palabras = "Come on rain down on me";
    
        File destino = new File("salida.txt");        
        
        try (Writer writer = new FileWriter(destino)) {
            
            for(int i = 0; i < palabras.length(); i++) {
                writer.write((int)palabras.charAt(i));
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrituraArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrituraArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

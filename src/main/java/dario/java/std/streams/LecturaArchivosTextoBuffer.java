package dario.java.std.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaArchivosTextoBuffer {

    public static void main(String[] args) {
        URL url = LecturaArchivosTextoBuffer.class.getResource("/entrada.txt");
        File file = new File(url.getFile());
        try (FileReader reader = new FileReader(file); 
                BufferedReader buffer = new BufferedReader(reader)) {
            String linea;
            while( (linea =  buffer.readLine()) != null ) {
                System.out.println(linea.split(linea));
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaArchivosTextoBuffer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaArchivosTextoBuffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

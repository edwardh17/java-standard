package dario.java.std.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaArchivosTexto {

    
    public static void main(String[] args) {
        URL url = LecturaArchivosTexto.class.getResource("/entrada.txt");
        File file = new File(url.getFile());

        try (FileReader reader = new FileReader(file)) {            
            int c;
            while( (c =  reader.read()) != -1 ) {
                System.out.print((char)c);
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);       
        }  
    }
    
    
    public static void main2(String[] args) {
        URL url = LecturaArchivosTexto.class.getResource("/entrada.txt");
        File file = new File(url.getFile());

        FileReader reader = null;
        try {
            reader = new FileReader(file);
            int c;
            while( (c =  reader.read()) != -1 ) {
                System.out.print((char)c);
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);       
        } finally {
            if (reader!=null) {
                try {
                    reader.close();
                } catch (IOException e) {                    
                }
          }
        }   
    }
    
}

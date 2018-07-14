package dario.java.std.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopiaArchivosTexto {

    public static void main(String[] args) {
        URL url = LecturaArchivosTexto.class.getResource("/entrada.txt");
        File destino = new File("salida.txt");

        File file = new File(url.getFile());

        try (Reader reader = new FileReader(file);
            Writer writer = new FileWriter(destino)) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaArchivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

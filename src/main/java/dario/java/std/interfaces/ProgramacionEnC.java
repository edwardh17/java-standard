package dario.java.std.interfaces;

public class ProgramacionEnC implements Programador {

    @Override
    public Codigo programar() {
        System.out.println("Estoy en programado en C");
        return new CodigoC("codigo en C");
    }
    
}

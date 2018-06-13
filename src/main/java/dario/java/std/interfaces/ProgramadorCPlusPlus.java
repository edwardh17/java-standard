package dario.java.std.interfaces;

public class ProgramadorCPlusPlus extends Persona implements Programador {
    
    private ProgramacionEnC programacionEnC;

    public ProgramadorCPlusPlus(String nombre, String apellido, int edad
            , ProgramacionEnC programacionEnC) {
        super(nombre, apellido, edad);
        this.programacionEnC = programacionEnC;
    }    
    
    @Override
    public Codigo programar() {
        return programacionEnC.programar();
    }
    
}

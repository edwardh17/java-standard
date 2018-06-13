package dario.java.std.interfaces;

public class ProgramadorC extends Persona implements Programador {
    
    private ProgramacionEnC programacionEnC;

    public ProgramadorC(String nombre, String apellido, int edad, ProgramacionEnC programacionEnC) {
        super(nombre, apellido, edad);
        this.programacionEnC = programacionEnC;
    }
    
    @Override
    public Codigo programar() {
        return programacionEnC.programar();
    }
    
}

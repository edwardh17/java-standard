package dario.java.std.interfaces;

public class ProgramadorNovato extends Persona implements Programador {

    public ProgramadorNovato(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public Codigo programar() {
        throw new RuntimeException(getNombre() + " No se programar");
    }
        
}

package dario.java.std.interfaces;

public class ProgramadorJava extends ProgramadorNovato /*implements Programador*/ {

    public ProgramadorJava(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public Codigo programar() {
        System.out.println(getNombre()+ " - Programando en Java");
        return new CodigoJava("codigo JAVA");
    }
    
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
 
   
}

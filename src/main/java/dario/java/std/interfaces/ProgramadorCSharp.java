package dario.java.std.interfaces;

public class ProgramadorCSharp extends ProgramadorNovato /*implements Programador*/ {

    public ProgramadorCSharp(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public Codigo programar() {
        String codigoFuente = "lbkjasdhh flkj";
        Integer lineasCodigo = 1250;
        
        System.out.println(getNombre()+ " - Programando en C#");
        return new CodigoCSharp("codigo C#");
    }
    
    
    
   
}

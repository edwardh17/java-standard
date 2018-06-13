package dario.java.std.interfaces;

public class CodigoC extends Codigo {

    public CodigoC(String codigoFuente) {
        super(codigoFuente);
    }

    @Override
    public Binario compilar() {
        System.out.println("Compilando a Binario");
        return new BinarioC();
    }
    
    
    
}

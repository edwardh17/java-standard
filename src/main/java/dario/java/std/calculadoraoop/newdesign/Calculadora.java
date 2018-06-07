package dario.java.std.calculadoraoop.newdesign;

import dario.java.std.calculadoraoop.ErrorDeSistemaException;
import dario.java.std.calculadoraoop.TipoOperacionIncorrectaException;
import java.util.Scanner;

public class Calculadora {
        
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Operacion buffer = null;

        while (true) {

            System.out.println("Nueva operación:");
            System.out.println("-----------------");

            
                try {
                    Operando a = leerOperando();
                    buffer = obtenerOperacion(leerOperacion(), a, leerOperando());
                    String tipoOperacion;  
                    
                    while (!"".equals(tipoOperacion =leerOperacion()) ) {
                        
                        buffer = obtenerOperacion(tipoOperacion, buffer, leerOperando());
                    
                    }
                    
                    System.out.println("resultado:" + buffer.valor());

                } catch (TipoOperacionIncorrectaException exception) {
                    System.out.println("Operacion incorreta: " + exception.getTipoOperacion());
                    throw new ErrorDeSistemaException(exception);
                }
        }
    }
    
    private static Operacion obtenerOperacion(String tipoOperacion, Operando operandoA, Operando operandoB) throws TipoOperacionIncorrectaException {
        Operacion operacion = null;

        switch (tipoOperacion) {
            case "+":
                operacion = new Suma(operandoA, operandoB);
                break;
            case "-":
                operacion = new Resta(operandoA, operandoB);
                break;
            case "/":
                operacion = new Division(operandoA, operandoB);
                break;
            case "*":
                operacion = new Multiplicacion(operandoA, operandoB);
                break;
            /*case "p":
                operacion = new Potencia(simpleA, simpleB);
                break;
            case "r":
                operacion = new Raiz(simpleA, simpleB);*/
            default:
                throw new TipoOperacionIncorrectaException(tipoOperacion);
        }
        return operacion;
    }
    
    private static String leerOperacion() {
        System.out.print("operacion:");
        return scanner.nextLine();    
    }
    
    private static Simple leerOperando() {
        System.out.print("operando:");
        return new Simple(Double.parseDouble(scanner.nextLine()));
    }
                    

}

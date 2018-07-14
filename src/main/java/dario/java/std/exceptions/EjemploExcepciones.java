package dario.java.std.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EjemploExcepciones {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {
        
        FileReader reader= new FileReader("");
        try {            
            int dividendo = leerEntero("Ingrese Dividendo:");            
            int divisor = leerEntero("Ingrese Divisor:");
            float d = dividendo / divisor;
            System.out.println("Resultado: "+ d);
        } catch (ArithmeticException e) {
            System.out.println("Division por cero");
        } catch (ParametroInvalidoException th ) {
            System.out.println("Ingresó un parámetro invalido");
            th.printStackTrace();
            System.out.println("Mensaje:"+th.getMessage());
        } finally {
            System.out.println("Finally!!!");
        }
        
        System.out.println("Fin Aplicación");
                
        
    }
    
    private static int leerEntero(String mensaje) throws ParametroInvalidoException {
        try {
            System.out.println(mensaje);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            throw new ParametroInvalidoException("Ingreso un número inválida", nfe);
        }
        
    }

   
}

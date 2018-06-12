package dario.java.std;

import dario.java.std.interfaces.ProgramadorJava;

public class Comparar {
    
    
    public static void main(String[] args) {
        ProgramadorJava a= new ProgramadorJava("Juan", "Pérez", 50);
        ProgramadorJava b= new ProgramadorJava("Juan", "Pérez", 50);
        //Integer a = new Integer(10);
        //Integer b = new Integer(10);
             
        if (a.equals(b)) {
            System.out.println("A es Igual a B");
            System.out.println("a:"+a.toString());
        } else {
            System.out.println("A NO es Igual a B");
        }
   
        
    }
            
    
}

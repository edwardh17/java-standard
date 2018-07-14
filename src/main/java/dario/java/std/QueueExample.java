package dario.java.std;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class QueueExample {

    public static void main(String[] args) {

        LinkedList<Persona> personas = new LinkedList<>();
        personas.add(new Persona("Juan", "Pérez", "555555"));
        personas.add(new Persona("Juan", "Gómez", "2222222"));
        personas.add(new Persona("Juan", "Gómez", "666666666"));
        personas.add(new Persona("Hector", "Peralta", "2222222"));
        personas.add(new Persona("Darío", "Hruszecki", "33333333"));
        personas.add(new Persona("Nicolás", "Hruszecki", "33333334"));
        personas.add(new Persona("Norberto", "Hruszecki", "33333335"));
        personas.forEach(p -> System.out.println(p));
        
        
        System.out.println("peek:" + personas.peek());
        System.out.println("poll:" + personas.poll());
        System.out.println("peek:" + personas.peek());
        System.out.println("pop:" + personas.poll());
        
        System.out.println("removeLast:" + personas.removeLast());
        
        System.out.println("pollLast:" + personas.pollLast());
        
        
        /* 
            Si le pasamos un comparator parámetros no utiliza el orden 
            natural
        */
        
        System.out.println("Con prioridad por orden natural:");
        Queue<Persona> prioridadPorOrdenNatural = new PriorityQueue<>();
        prioridadPorOrdenNatural.add(new Persona("Juan", "Pérez", "55555555"));
        prioridadPorOrdenNatural.add(new Persona("Juan", "Gómez", "2222222"));
        prioridadPorOrdenNatural.add(new Persona("Juan", "Gómez", "66666666"));
        prioridadPorOrdenNatural.add(new Persona("Hector", "Peralta", "2222222"));
        prioridadPorOrdenNatural.add(new Persona("Darío", "Hruszecki", "33333333"));
        prioridadPorOrdenNatural.add(new Persona("Nicolás", "Hruszecki", "33333334"));
        prioridadPorOrdenNatural.add(new Persona("Norberto", "Hruszecki", "33333335"));
        
        while (!prioridadPorOrdenNatural.isEmpty())
            System.out.println(prioridadPorOrdenNatural.poll());
        
        
        System.out.println("Con prioridad por dni:");
        Queue<Persona> prioridadPorApellido = new PriorityQueue<>(new PrioridadPorApellido());
        prioridadPorApellido.add(new Persona("Juan", "Pérez", "55555555"));
        prioridadPorApellido.add(new Persona("Juan", "Gómez", "2222222"));
        prioridadPorApellido.add(new Persona("Juan", "Gómez", "66666666"));
        prioridadPorApellido.add(new Persona("Hector", "Peralta", "2222222"));
        prioridadPorApellido.add(new Persona("Darío", "Hruszecki", "33333333"));
        prioridadPorApellido.add(new Persona("Nicolás", "Hruszecki", "33333334"));
        prioridadPorApellido.add(new Persona("Norberto", "Hruszecki", "33333335"));
        
        while (!prioridadPorApellido.isEmpty())
            System.out.println(prioridadPorApellido.poll());

    }
    
    
    
}

class PrioridadPorApellido implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getDni().compareTo(o2.getDni());
    }
    
    
}

package dario.java.std.sudoku;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Cuadrante {

    private int[][] data = new int[3][3];
    private Set<Integer> valores = new HashSet<>();

    private Optional<Cuadrante> norte;
    private Optional<Cuadrante> sur;
    private Optional<Cuadrante> este;
    private Optional<Cuadrante> oeste;

    public Cuadrante(Optional<Cuadrante> norte,
            Optional<Cuadrante> sur,
            Optional<Cuadrante> este,
            Optional<Cuadrante> oeste) {
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
        generar();
    }

    public boolean hayColisionFila(int file, int valor) {
        return false;
    }

    public boolean hayColisionColumna(int file, int valor) {
        return false;
    }

    private void generar() {

        for (int fila = 0; fila < data.length; fila++) {
            for (int columna = 0; columna < data.length; columna++) {

                Random random = new Random();
                int candidato = random.nextInt(9) + 1;

                if ((!valores.contains(candidato)
                        && oeste.isPresent() && !oeste.get().hayColisionFila(fila, candidato))
                        && (este.isPresent() && !este.get().hayColisionFila(fila, candidato))
                        && (norte.isPresent() && !norte.get().hayColisionColumna(columna, candidato))
                        && (sur.isPresent() && !sur.get().hayColisionColumna(columna, candidato))) {
                    data[fila][columna] = candidato;
                    valores.add(candidato);
                }
            }
        }

    }

    public void print() {
        
        for (int fila = 0; fila < data.length; fila++) {
            for (int columna = 0; columna < data.length; columna++) {
                System.out.print(data[fila][columna]+ " ");
            }
            System.out.println("");
        }
    }
    
    
    public static void main(String[] args) {
        Cuadrante c = new Cuadrante(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
        c.print();
    }
    

}

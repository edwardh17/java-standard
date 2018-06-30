package dario.java.std.sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Cuadrante {

    private int[][] data = new int[3][3];
    private Set<Integer> valores = new HashSet<>();

    private final Set<Integer> numeros = new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    private List<Cuadrante> horizontales;
    private List<Cuadrante> verticales;

    public Cuadrante(List<Cuadrante> horizontales,
            List<Cuadrante> verticales) {
        this.horizontales = horizontales;
        this.verticales = verticales;

        generar();
    }

    public boolean hayColisionFila(int fila, int valor) {
        for (int i = 0; i < 3; i++) {
            if (data[fila][i] == valor) {
                return true;
            }
        }
        return false;
    }

    public boolean hayColisionColumna(int columna, int valor) {
        for (int i = 0; i < 3; i++) {
            if (data[i][columna] == valor) {
                return false;
            }
        }
        return true;
    }

    private void generar() {
        for (int fila = 0; fila < data.length; fila++) {
            for (int columna = 0; columna < data.length; columna++) {
                int candidato = buscarCandidato(fila, columna);
                if (candidato == -1) {
                    throw new RuntimeException("No hay Candidato " + fila + " : " + columna);
                }
                agregarNumero(fila, columna, candidato);
            }
        }
    }

    private int buscarCandidato(final int fila, final int columna) {
        Set<Integer> candidatos = new HashSet(numeros);
        candidatos.removeAll(valores);
        
        List<Integer> candidatosValidos =  candidatos.stream().filter(candidato -> esCandidatoValido(fila, columna, candidato)).collect(Collectors.toList()); ;

        if (candidatosValidos.isEmpty()) {
            return -1;
        } else {
            Random r = new Random();
            return candidatosValidos.get(r.nextInt(candidatosValidos.size()));
        }

    }

    private boolean esCandidatoValido(final int fila, final int columna, int candidato) {
        return (!valores.contains(candidato))
                && horizontales.stream().allMatch(c -> !c.hayColisionFila(fila, candidato))
                && verticales.stream().allMatch(c -> !c.hayColisionColumna(columna, candidato));
    }

    private void agregarNumero(int fila, int columna, int candidato) {
        data[fila][columna] = candidato;
        valores.add(candidato);
    }

    public void print() {

        for (int fila = 0; fila < data.length; fila++) {
            for (int columna = 0; columna < data.length; columna++) {
                System.out.print(data[fila][columna] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Cuadrante c1 = new Cuadrante(Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        c1.print();
                 
        Cuadrante c2 = new Cuadrante(Arrays.asList(c1), Collections.EMPTY_LIST);
        c2.print();

        Cuadrante c3 = new Cuadrante(Arrays.asList(c1,c2), Collections.EMPTY_LIST);
        c3.print();
        
        Cuadrante c4 = new Cuadrante(Collections.EMPTY_LIST, Arrays.asList(c1));
        c4.print();
                 
        Cuadrante c5 = new Cuadrante(Arrays.asList(c4), Arrays.asList(c2));
        c5.print();

        Cuadrante c6 = new Cuadrante(Arrays.asList(c4,c5), Arrays.asList(c3));
        c6.print();

        
    }

}

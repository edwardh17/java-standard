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

    private int fila;
    private int columna;
    private List<Cuadrante> horizontales;
    private List<Cuadrante> verticales;

    private Random random = new Random();


    public Cuadrante(int fila, int columna, List<Cuadrante> horizontales,
            List<Cuadrante> verticales) {
        this.horizontales = horizontales;
        this.verticales = verticales;
        this.fila = fila;
        this.columna  = columna;

        generar();
    }

    public Cuadrante(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void setHorizontales(List<Cuadrante> horizontales) {
        this.horizontales = horizontales;
    }

    public void setVerticales(List<Cuadrante> verticales) {
        this.verticales = verticales;
    }

    public int[][] getData() {
        return data;
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

    public void generar() {
        for (int fila = 0; fila < data.length; fila++) {
            for (int columna = 0; columna < data.length; columna++) {
                int candidato = buscarCandidato(fila, columna);
                if (candidato == -1) {
                    throw new RuntimeException("Cuadrante ["+ fila + "," + columna+"] No hay Candidato " + fila + " : " + columna);
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
            return candidatosValidos.get(random.nextInt(candidatosValidos.size()));
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

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public static void main(String[] args) {

        int count=0;
        do {
            try {
                Cuadrante c22 = new Cuadrante(2,2,Collections.EMPTY_LIST, Collections.EMPTY_LIST);

                Cuadrante c12 = new Cuadrante(1,2, Collections.EMPTY_LIST, Arrays.asList(c22));

                Cuadrante c32 = new Cuadrante(3,2, Collections.EMPTY_LIST, Arrays.asList(c22));

                Cuadrante c21 = new Cuadrante(2,1,Arrays.asList(c22), Collections.EMPTY_LIST);

                Cuadrante c23 = new Cuadrante(2,3,Arrays.asList(c22, c21), Collections.EMPTY_LIST);

                Cuadrante c11 = new Cuadrante(1,1,Arrays.asList(c12), Arrays.asList(c21));

                Cuadrante c13 = new Cuadrante(1,3,Arrays.asList(c11, c12), Arrays.asList(c23));

                Cuadrante c31 = new Cuadrante(3,1,Arrays.asList(c32), Arrays.asList(c11, c21));

                Cuadrante c33 = new Cuadrante(3,3,Arrays.asList(c31, c32), Arrays.asList(c13, c23));

                Sudoku sudoku = new Sudoku(c11,c12,c13,c21,c22,c23,c31,c32,c33);

                sudoku.print();

                break;

            } catch (Throwable th) {
                System.out.println("Error al generar sudoku - intento: " + count++ + " - " + th.getMessage());
            }
        } while (count < 2000);
    }

}

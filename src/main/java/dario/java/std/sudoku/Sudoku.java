package dario.java.std.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sudoku {

    private int[][] data;
    private Cuadrante[][] cuadrantes;


    public Sudoku(Cuadrante... cuadrantes) {
        this.cuadrantes = new Cuadrante[][] {{cuadrantes[0], cuadrantes[1], cuadrantes[2]},
                {cuadrantes[3], cuadrantes[4], cuadrantes[5]},
                {cuadrantes[6], cuadrantes[7], cuadrantes[8]}};

        popularData();

    }

    private void popularData() {
        data = new int[9][9];

        for (int fila=0; fila < 9 ; fila++) {
            for (int columna=0; columna < 9; columna++) {
                int filaC = indexCuadrante(fila);
                int columnaC = indexCuadrante(columna);
                int filaD = indexData(fila,filaC);
                int columnaD = indexData(columna,columnaC);

                data[fila][columna]=this.cuadrantes[filaC][columnaC].getData()[filaD][columnaD];
            }
        }
    }

    public Sudoku() {
        cuadrantes = new Cuadrante[3][3];

        for (int fila=0; fila < 3 ; fila++) {
            for (int columna=0; columna < 3; columna++) {
                cuadrantes[fila][columna]=new Cuadrante(fila,columna);
            }
        }

        for (int fila=0; fila < 3 ; fila++) {
            for (int columna=0; columna < 3; columna++) {
                cuadrantes[fila][columna].setHorizontales(vecinosHorizontales(fila));
                cuadrantes[fila][columna].setVerticales(vecinosVerticales(fila));
            }
        }

    }

    public void generar() {
        for (int fila=0; fila < 3 ; fila++) {
            for (int columna=0; columna < 3; columna++) {
                cuadrantes[fila][columna].generar();
            }
        }

        popularData();
    }

    private List<Cuadrante> cuadrantesPorFila(int fila) {
        List<Cuadrante> cuadrantesPorFila = new ArrayList<>();
        for (int columna=0; columna < 3; columna++) {
            cuadrantesPorFila.add(cuadrantes[fila][columna]);
        }
        return cuadrantesPorFila;
    }

    private List<Cuadrante> cuadrantesPorColumna(int columna) {
        List<Cuadrante> cuadrantesPorColumna = new ArrayList<>();
        for (int fila=0; fila < 3; fila++) {
            cuadrantesPorColumna.add(cuadrantes[fila][columna]);
        }
        return cuadrantesPorColumna;
    }


    private List<Cuadrante> vecinosHorizontales(int fila) {
        return cuadrantesPorFila(fila).stream().filter(c -> c.getFila()!=fila).collect(Collectors.toList());
    }

    private List<Cuadrante> vecinosVerticales(int columna) {
        return cuadrantesPorColumna(columna).stream().filter(c -> c.getColumna()!=columna).collect(Collectors.toList());
    }


    private int indexCuadrante(int index) {
        int indexC = 2;
        if (index < 3) indexC = 0;
        else if (index < 6) indexC = 1;
        return indexC;
    }

    private int indexData(int index, int indexC) {
        return index-(indexC*3);
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
        Sudoku sudoku = new Sudoku();
        sudoku.generar();
        sudoku.print();
    }
}

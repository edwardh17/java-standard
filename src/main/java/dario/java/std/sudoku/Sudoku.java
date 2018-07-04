package dario.java.std.sudoku;

public class Sudoku {

    private int[][] data;
    private Cuadrante[][] cuadrantes;


    public Sudoku(Cuadrante... cuadrantes) {
        this.cuadrantes = new Cuadrante[][] {{cuadrantes[0], cuadrantes[1], cuadrantes[2]},
                {cuadrantes[3], cuadrantes[4], cuadrantes[5]},
                {cuadrantes[6], cuadrantes[7], cuadrantes[8]}};

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

    private int indexCuadrante(int index) {
        int indexC = 2;
        if (index < 3) indexC = 0;
        else if (index < 6) indexC = 1;
        return indexC;
    }

    private int indexData(int index, int indexC) {
        return index+(indexC*3);
    }

    public void print() {
        for (int fila=0; fila < 9 ; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                System.out.print(data[fila][columna]);
            }
        }
    }
}

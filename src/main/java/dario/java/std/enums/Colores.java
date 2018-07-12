package dario.java.std.enums;

public enum Colores {
       
    ROJO("93FF33"), AZUL("93FF33"), VERDE("93FF33"), AMARILLO("93FF33");

    private String hex;

    private Colores(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

}

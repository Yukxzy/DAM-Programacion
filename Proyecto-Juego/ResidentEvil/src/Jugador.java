
public class Jugador {

    // INVENTARIO DEL JUGADOR
    private boolean tieneLlave = false;
    private boolean tieneTarjeta = false;
    private boolean tieneArma = false;
    private boolean tieneBotiquin = false;

    // METODOS PARA CONSEGUIR OBJETOS
    public void conseguirLlave() {
        tieneLlave = true;
    }

    public void conseguirTarjeta() {
        tieneTarjeta = true;
    }

    public void conseguirArma() {
        tieneArma = true;
    }

    public void conseguirBotiquin() {
        tieneBotiquin = true;
    }

    // METODOS PARA COMPROBAR EL INVENTARIO
    public boolean tieneLlave() {
        return tieneLlave;
    }

    public boolean tieneTarjeta() {
        return tieneTarjeta;
    }

    public boolean tieneArma() {
        return tieneArma;
    }

    public boolean tieneBotiquin() {
        return tieneBotiquin;
    }

    // MOSTRAR INVENTARIO
    public void mostrarInventario() {

        System.out.println();
        System.out.println("===== INVENTARIO =====");
        System.out.println("Llave: " + tieneLlave);
        System.out.println("Tarjeta de seguridad: " + tieneTarjeta);
        System.out.println("Arma: " + tieneArma);
        System.out.println("Botiquin: " + tieneBotiquin);
        System.out.println("======================");

    }

}

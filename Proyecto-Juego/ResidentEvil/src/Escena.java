
public class Escena {

    // DATOS DE LA HABITACION
    private int numero;
    private String nombre;
    private String descripcion;

    // CONSTRUCTOR
    public Escena(int numero, String nombre, String descripcion) {

        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    // MOSTRAR HABITACION
    public void mostrarEscena() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("          " + nombre);
        System.out.println("==================================");

        mostrarTexto(descripcion);

    }

    // MOSTRAR TEXTO CON PAUSA
    public void mostrarTexto(String texto) {

        System.out.println(texto);

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    // OBTENER NUMERO
    public int getNumero() {
        return numero;
    }

    // OBTENER NOMBRE
    public String getNombre() {
        return nombre;
    }

    // OBTENER DESCRIPCION
    public String getDescripcion() {
        return descripcion;
    }

}

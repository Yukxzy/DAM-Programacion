
public class Escena {

    // DATOS DE LA ESCENA
    private int numero;
    private String nombre;
    private String descripcion;

    // CONSTRUCTOR
    public Escena(int numero, String nombre, String descripcion) {

        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    // MOSTRAR INFORMACION DE LA ESCENA
    public void mostrarEscena() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("ESCENA " + numero + ": " + nombre);
        System.out.println("==================================");
        System.out.println(descripcion);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Error en la pausa.");
        }

    }

    // OBTENER EL NUMERO
    public int getNumero() {
        return numero;
    }

    // OBTENER EL NOMBRE
    public String getNombre() {
        return nombre;
    }

    // OBTENER LA DESCRIPCION
    public String getDescripcion() {
        return descripcion;
    }

}

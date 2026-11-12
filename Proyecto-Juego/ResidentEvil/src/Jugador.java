
import java.util.ArrayList;

public class Jugador {

    // INVENTARIO
    private ArrayList<String> inventario;

    // CONSTRUCTOR
    public Jugador() {
        inventario = new ArrayList<String>();
    }

    // RECOGER OBJETOS
    public void recogerObjeto(String objeto) {

        if (!inventario.contains(objeto)) {

            inventario.add(objeto);

            System.out.println();
            System.out.println("Has conseguido: " + objeto);

        } else {

            System.out.println("Ya tienes este objeto.");

        }

    }

    // COMPROBAR SI TIENES UN OBJETO
    public boolean tieneObjeto(String objeto) {

        return inventario.contains(objeto);

    }

    // UTILIZAR OBJETOS
    public boolean usarObjeto(String objeto) {

        if (inventario.contains(objeto)) {

            inventario.remove(objeto);

            System.out.println("Has utilizado: " + objeto);

            return true;

        } else {

            System.out.println("No tienes ese objeto.");

            return false;

        }

    }

    // MOSTRAR INVENTARIO
    public void mostrarInventario() {

        System.out.println();
        System.out.println("========== INVENTARIO ==========");

        if (inventario.isEmpty()) {

            System.out.println("No tienes ningun objeto.");

        } else {

            for (int i = 0; i < inventario.size(); i++) {

                System.out.println((i + 1) + ". " + inventario.get(i));

            }

        }

        System.out.println("================================");

    }

}

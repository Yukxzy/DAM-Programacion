
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Jugador jugador = new Jugador();

        boolean rescataSuperviviente = false;
        boolean activaAutodestruccion = false;

        int opcion;

        System.out.println("==================================");
        System.out.println("       RESIDENT EVIL");
        System.out.println("     EL ULTIMO EXPERIMENTO");
        System.out.println("==================================");

        mostrarTexto("Bienvenido a nuestra aventura.");
        mostrarTexto("Eres un policia novato y has recibido");
        mostrarTexto("una llamada de emergencia...");

        mostrarTexto("RACCOON CITY - 23:47");

        mostrarTexto("La lluvia cae con fuerza.");
        mostrarTexto("Tu coche se detiene frente a una");
        mostrarTexto("enorme mansion abandonada.");

        mostrarTexto("Debes investigar lo que ocurre dentro.");

        // ESCENA 1
        mostrarEscena(1, "La mansion",
                "Debes decidir como comenzar la investigacion.");

        System.out.println("¿QUE QUIERES HACER?");
        System.out.println("1. Entrar en la mansion.");
        System.out.println("2. Investigar los alrededores.");

        opcion = leerOpcion(teclado, 2);

        if (opcion == 2) {

            // ESCENA 2
            mostrarEscena(2, "Los alrededores",
                    "Investigas el exterior de la mansion.");

            mostrarTexto("Encuentras unas huellas extrañas.");
            mostrarTexto("Junto a un arbol encuentras un botiquin.");

            jugador.conseguirBotiquin();

            mostrarTexto("Has conseguido un botiquin.");

            mostrarTexto("Un ruido procede de la mansion.");
            mostrarTexto("Decides entrar para investigar.");

        } else {

            mostrarTexto("Entras lentamente en la mansion...");
            mostrarTexto("La puerta se cierra detras de ti.");

        }

        // ESCENA 3
        mostrarEscena(3, "El recibidor",
                "Te encuentras en un enorme recibidor.");

        mostrarTexto("Escuchas un ruido en el piso de arriba.");

        System.out.println();
        System.out.println("¿QUE QUIERES HACER?");
        System.out.println("1. Investigar el salon.");
        System.out.println("2. Subir las escaleras.");

        int decision = leerOpcion(teclado, 2);

        // ESCENA 4 Y 5
        if (decision == 1) {

            mostrarEscena(4, "El salon",
                    "Entras en el salon de la mansion.");

            mostrarTexto("Encuentras un cajon abierto.");
            mostrarTexto("Dentro encuentras una llave pequeña.");
            mostrarTexto("La guardas en tu inventario.");

            jugador.conseguirLlave();

        } else {

            mostrarEscena(5, "Las escaleras",
                    "Subes lentamente las escaleras.");

            mostrarTexto("Escuchas un ruido detras de una puerta.");

            if (jugador.tieneLlave() == true) {

                mostrarTexto("Recuerdas que tienes una llave.");

            } else {

                mostrarTexto("No tienes ninguna llave.");
                mostrarTexto("Decides bajar y buscar en el salon.");

                mostrarTexto("Entras en el salon.");
                mostrarTexto("Encuentras un cajon abierto.");
                mostrarTexto("Dentro encuentras una llave pequeña.");

                jugador.conseguirLlave();

            }

        }

        // ESCENA 6
        mostrarEscena(6, "La puerta cerrada",
                "Una puerta bloquea tu camino.");

        mostrarTexto("De repente, escuchas un ruido en el piso de arriba.");
        mostrarTexto("La llave podria servir para abrir alguna puerta.");
        mostrarTexto("Decides subir las escaleras.");

        if (jugador.tieneLlave() == true) {

            mostrarTexto("Llegas a la puerta cerrada.");
            mostrarTexto("Utilizas la llave para abrirla.");
            mostrarTexto("La puerta se abre lentamente...");
            mostrarTexto("Entras en una habitacion oscura.");

        }

        // ESCENA 7
        mostrarEscena(7, "La habitacion oscura",
                "Entras en una habitacion llena de documentos.");

        mostrarTexto("Encuentras un ordenador encendido.");
        mostrarTexto("En la pantalla aparece un mensaje:");
        mostrarTexto("EXPERIMENTO 042 - SUJETO ESCAPADO");

        // ESCENA 8
        mostrarEscena(8, "Los documentos y el ordenador",
                "Debes decidir como investigar la informacion.");

        System.out.println("¿QUE QUIERES HACER?");
        System.out.println("1. Leer los documentos.");
        System.out.println("2. Examinar el ordenador.");

        int decisionOrdenador = leerOpcion(teclado, 2);

        if (decisionOrdenador == 1) {

            mostrarTexto("Lees los documentos cuidadosamente.");
            mostrarTexto("Descubres que la mansion esconde");
            mostrarTexto("un laboratorio secreto.");

            mostrarTexto("Tambien encuentras una tarjeta de seguridad.");

            jugador.conseguirTarjeta();

            mostrarTexto("Has conseguido una tarjeta de seguridad.");

        } else {

            mostrarTexto("Examinas el ordenador.");
            mostrarTexto("Encuentras un archivo de seguridad.");
            mostrarTexto("El archivo esta protegido por una contraseña.");

            // ESCENA 9
            mostrarEscena(9, "Prueba de seguridad",
                    "Debes adivinar la contraseña del ordenador.");

            boolean haSuperadoPrueba = jugarAhorcado(teclado);

            if (haSuperadoPrueba == true) {

                mostrarTexto("¡Has conseguido desbloquear el ordenador!");
                mostrarTexto("Encuentras una tarjeta de seguridad.");

                jugador.conseguirTarjeta();

            } else {

                mostrarTexto("Has fallado la prueba de seguridad.");
                mostrarTexto("Una alarma comienza a sonar.");
                mostrarTexto("Algo se acerca por el pasillo...");

                System.out.println();
                System.out.println("==================================");
                System.out.println("           FINAL MALO");
                System.out.println("==================================");

                mostrarTexto("La criatura te encuentra antes de escapar.");
                mostrarTexto("Tu investigacion termina aqui.");

                teclado.close();
                return;

            }

        }

        // ESCENA 10
        mostrarEscena(10, "El pasillo del laboratorio",
                "Encuentras una puerta metalica.");

        mostrarTexto("Un lector de tarjetas bloquea la entrada.");

        if (jugador.tieneTarjeta() == true) {

            mostrarTexto("Utilizas la tarjeta de seguridad.");
            mostrarTexto("La puerta se desbloquea.");

        } else {

            mostrarTexto("No tienes la tarjeta necesaria.");
            mostrarTexto("No puedes entrar en el laboratorio.");

            teclado.close();
            return;

        }

        // ESCENA 11
        mostrarEscena(11, "El laboratorio",
                "Descubres el laboratorio secreto.");

        mostrarTexto("Hay camaras, ordenadores y jaulas abiertas.");
        mostrarTexto("Parece que aqui se realizaban experimentos.");

        mostrarTexto("Encuentras un arma sobre una mesa.");
        mostrarTexto("La recoges para protegerte.");

        jugador.conseguirArma();

        mostrarTexto("Has conseguido un arma.");

        // ESCENA 12
        mostrarEscena(12, "Investigacion del laboratorio",
                "Debes decidir que zona investigar.");

        System.out.println("¿QUE QUIERES HACER?");
        System.out.println("1. Examinar los ordenadores.");
        System.out.println("2. Investigar las jaulas.");

        int decisionLaboratorio = leerOpcion(teclado, 2);

        if (decisionLaboratorio == 1) {

            mostrarTexto("Revisas los ordenadores.");
            mostrarTexto("Descubres que existe un sistema");
            mostrarTexto("de autodestruccion del laboratorio.");

            activaAutodestruccion = true;

        } else {

            mostrarTexto("Te acercas a las jaulas.");
            mostrarTexto("Escuchas una voz pidiendo ayuda.");
            mostrarTexto("Encuentras a un cientifico herido.");

            System.out.println("¿QUE QUIERES HACER?");
            System.out.println("1. Ayudar al cientifico.");
            System.out.println("2. Continuar sin detenerte.");

            int decisionCientifico = leerOpcion(teclado, 2);

            if (decisionCientifico == 1) {

                mostrarTexto("Ayudas al cientifico a levantarse.");
                mostrarTexto("Te explica como escapar del laboratorio.");

                rescataSuperviviente = true;

                if (jugador.tieneBotiquin() == true) {

                    mostrarTexto("Utilizas tu botiquin para curarlo.");

                }

            } else {

                mostrarTexto("Decides continuar solo.");
                mostrarTexto("El cientifico se queda atras.");

            }

        }

        // ESCENA 13
        mostrarEscena(13, "La criatura",
                "El sujeto 042 aparece ante ti.");

        mostrarTexto("Las luces comienzan a parpadear.");
        mostrarTexto("Una criatura enorme aparece al final del pasillo.");
        mostrarTexto("¡ES EL SUJETO DEL EXPERIMENTO 042!");

        System.out.println();
        System.out.println("¿QUE QUIERES HACER?");
        System.out.println("1. Enfrentarte a la criatura.");
        System.out.println("2. Intentar escapar.");

        int decisionCriatura = leerOpcion(teclado, 2);

        if (decisionCriatura == 1) {

            if (jugador.tieneArma() == true) {

                mostrarTexto("Levantas tu arma y disparas.");
                mostrarTexto("La criatura cae al suelo.");
                mostrarTexto("Consigues derrotarla.");

            } else {

                mostrarTexto("No tienes nada con lo que defenderte.");

                System.out.println();
                System.out.println("==================================");
                System.out.println("           FINAL MALO");
                System.out.println("==================================");

                mostrarTexto("La criatura te alcanza.");
                mostrarTexto("No consigues escapar de la mansion.");

                teclado.close();
                return;

            }

        } else {

            mostrarTexto("Corres por el pasillo.");
            mostrarTexto("La criatura te persigue.");

            if (activaAutodestruccion == true) {

                mostrarTexto("El sistema de autodestruccion comienza.");
                mostrarTexto("Las puertas se cierran detras de ti.");

            } else {

                mostrarTexto("Consigues esconderte en una sala.");
                mostrarTexto("La criatura pierde tu rastro.");

            }

        }

        // ESCENA 14
        mostrarEscena(14, "La decision final",
                "Debes decidir el destino del experimento.");

        mostrarTexto("Llegas a la salida de la mansion.");
        mostrarTexto("La lluvia sigue cayendo en el exterior.");
        mostrarTexto("Pero escuchas otra alarma en el laboratorio.");

        System.out.println();
        System.out.println("¿QUE QUIERES HACER?");
        System.out.println("1. Escapar inmediatamente.");
        System.out.println("2. Volver para destruir el experimento.");

        int decisionFinal = leerOpcion(teclado, 2);

        // FINALES
        if (decisionFinal == 1) {

            if (rescataSuperviviente == true) {

                System.out.println();
                System.out.println("==================================");
                System.out.println("          FINAL BUENO");
                System.out.println("==================================");

                mostrarTexto("Escapas de la mansion junto al cientifico.");
                mostrarTexto("La policia recibe toda la informacion.");
                mostrarTexto("El experimento sale a la luz.");
                mostrarTexto("¡Has conseguido salvar una vida!");

            } else {

                System.out.println();
                System.out.println("==================================");
                System.out.println("         FINAL NEUTRAL");
                System.out.println("==================================");

                mostrarTexto("Consigues escapar de la mansion.");
                mostrarTexto("Sin embargo, el experimento sigue activo.");
                mostrarTexto("Nadie sabe que ocurrira despues.");

            }

        } else {

            if (activaAutodestruccion == true && jugador.tieneArma() == true) {

                System.out.println();
                System.out.println("==================================");
                System.out.println("          FINAL BUENO");
                System.out.println("==================================");

                mostrarTexto("Vuelves al laboratorio.");
                mostrarTexto("Activan la autodestruccion.");
                mostrarTexto("Consigues escapar antes de la explosion.");
                mostrarTexto("¡El experimento ha sido destruido!");

            } else {

                System.out.println();
                System.out.println("==================================");
                System.out.println("           FINAL MALO");
                System.out.println("==================================");

                mostrarTexto("Regresas al laboratorio.");
                mostrarTexto("La criatura vuelve a aparecer.");
                mostrarTexto("Las puertas se bloquean.");
                mostrarTexto("No consigues salir a tiempo.");

            }

        }

        // INVENTARIO FINAL
        jugador.mostrarInventario();

        // MATRIZ BIDIMENSIONAL
        System.out.println();
        System.out.println("==================================");
        System.out.println("       REGISTRO DEL LABORATORIO");
        System.out.println("==================================");

        String[][] registro = {
                {"SUJETO", "ESTADO"},
                {"001", "FALLECIDO"},
                {"002", "DESAPARECIDO"},
                {"042", "ESCAPADO"}
        };

        for (int fila = 0; fila < registro.length; fila++) {

            System.out.println(registro[fila][0] + " - " + registro[fila][1]);

        }

        mostrarTexto("Gracias por jugar a RESIDENT EVIL.");

        teclado.close();

    }

    // METODO PARA MOSTRAR ESCENAS
    public static void mostrarEscena(int numero, String nombre, String descripcion) {

        Escena escena = new Escena(numero, nombre, descripcion);

        escena.mostrarEscena();

    }

    // METODO PARA LEER OPCIONES
    public static int leerOpcion(Scanner teclado, int maximo) {

        int opcion = 0;

        do {

            System.out.print("Elige una opcion: ");

            if (teclado.hasNextInt()) {

                opcion = teclado.nextInt();

                if (opcion < 1 || opcion > maximo) {
                    System.out.println("Opcion incorrecta. Intentalo de nuevo.");
                }

            } else {

                System.out.println("Debes introducir un numero.");
                teclado.next();

            }

        } while (opcion < 1 || opcion > maximo);

        return opcion;

    }

    // METODO SOBRECARGADO 1
    public static void mostrarTexto(String texto) {

        System.out.println(texto);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error en la pausa.");
        }

    }

    // METODO SOBRECARGADO 2
    public static void mostrarTexto(String texto, String texto2) {

        mostrarTexto(texto);
        mostrarTexto(texto2);

    }

    // MINIJUEGO DEL AHORCADO
    public static boolean jugarAhorcado(Scanner teclado) {

        String palabra = "LLAVE";
        String respuesta;

        int intentos = 3;

        System.out.println();
        System.out.println("==================================");
        System.out.println("          PRUEBA DE SEGURIDAD");
        System.out.println("==================================");

        mostrarTexto("Debes adivinar la contraseña.");
        mostrarTexto("Pista: objeto que abre puertas.");
        mostrarTexto("Tienes 3 intentos.");

        while (intentos > 0) {

            System.out.println();
            System.out.print("Introduce la palabra: ");

            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase(palabra)) {

                mostrarTexto("¡Correcto!");
                return true;

            } else {

                intentos--;

                mostrarTexto("Respuesta incorrecta.");
                System.out.println("Intentos restantes: " + intentos);

            }

        }

        mostrarTexto("Te has quedado sin intentos.");

        return false;

    }

}

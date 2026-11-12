
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static Jugador jugador = new Jugador();

    // Objetos que siguen disponibles en las habitaciones
    static Set<String> objetosDisponibles = new HashSet<>();

    // Estado de la aventura
    static boolean codigoDescubierto = false;
    static boolean cajonAbierto = false;
    static boolean cajaAbierta = false;
    static boolean generadorActivado = false;
    static boolean puertaLaboratorioAbierta = false;
    static boolean cientificoSalvado = false;
    static boolean criaturaDerrotada = false;

    public static void main(String[] args) {

        objetosDisponibles.add("Destornillador");
        objetosDisponibles.add("Botiquin");
        objetosDisponibles.add("Llave pequeña");
        objetosDisponibles.add("Fusible");
        objetosDisponibles.add("Tarjeta de seguridad");
        objetosDisponibles.add("Arma");

        System.out.println("======================================");
        System.out.println("             RESIDENT EVIL");
        System.out.println("          EL ULTIMO EXPERIMENTO");
        System.out.println("======================================");

        pausa();

        mostrarTexto("RACCOON CITY - 23:47");
        mostrarTexto("Una llamada de emergencia te lleva");
        mostrarTexto("hasta una mansion abandonada.");
        mostrarTexto("Algo terrible ha ocurrido en su interior.");

        mostrarTexto("Tu objetivo es investigar la mansion");
        mostrarTexto("y descubrir que ha sucedido.");

        recibidor();
    }

    // ==========================================
    // RECIBIDOR
    // ==========================================

    public static void recibidor() {

        int opcion;

        do {

            mostrarEscena("RECIBIDOR",
                    "Un recibidor oscuro. La puerta principal esta cerrada.");

            System.out.println("1. Ir al salon.");
            System.out.println("2. Ir a la cocina.");
            System.out.println("3. Ir a la biblioteca.");
            System.out.println("4. Ir al pasillo.");
            System.out.println("5. Consultar inventario.");
            System.out.println("6. Examinar la puerta principal.");
            System.out.println("7. Salir del juego.");

            opcion = leerOpcion(7);

            switch (opcion) {

                case 1:
                    salon();
                    break;

                case 2:
                    cocina();
                    break;

                case 3:
                    biblioteca();
                    break;

                case 4:
                    pasillo();
                    break;

                case 5:
                    jugador.mostrarInventario();
                    pausa();
                    break;

                case 6:
                    mostrarTexto("Intentas abrir la puerta principal.");
                    mostrarTexto("Pero esta bloqueada desde el exterior.");
                    mostrarTexto("Tendras que encontrar otra salida.");
                    pausa();
                    break;

                case 7:
                    mostrarTexto("Has abandonado la partida.");
                    System.exit(0);
                    break;
            }

        } while (true);
    }

    // ==========================================
    // SALON
    // ==========================================

    public static void salon() {

        int opcion;

        do {

            mostrarEscena("SALON",
                    "Un salon antiguo. Hay un sofa, una chimenea y un cajon cerrado.");

            System.out.println("1. Examinar el sofa.");
            System.out.println("2. Examinar el cajon.");
            System.out.println("3. Examinar la chimenea.");
            System.out.println("4. Volver al recibidor.");
            System.out.println("5. Consultar inventario.");

            opcion = leerOpcion(5);

            switch (opcion) {

                case 1:
                    mostrarTexto("El sofa esta roto y lleno de polvo.");
                    mostrarTexto("No encuentras nada util.");
                    pausa();
                    break;

                case 2:

                    if (!cajonAbierto) {

                        if (jugador.tieneObjeto("Llave pequeña")) {

                            mostrarTexto("La llave pequeña encaja en la cerradura.");

                            cajonAbierto = true;

                            jugador.usarObjeto("Llave pequeña");

                            mostrarTexto("Abres el cajon.");
                            mostrarTexto("Dentro encuentras una tarjeta de seguridad.");

                            interactuarObjeto(
                                    "Tarjeta de seguridad",
                                    "Una tarjeta electronica con el simbolo de Umbrella.",
                                    "Parece servir para abrir puertas de seguridad."
                            );

                        } else {

                            mostrarTexto("El cajon esta cerrado con llave.");
                            mostrarTexto("Necesitas encontrar una llave pequeña.");

                        }

                    } else {

                        mostrarTexto("El cajon esta abierto y vacio.");

                    }

                    pausa();
                    break;

                case 3:
                    mostrarTexto("La chimenea esta apagada.");
                    mostrarTexto("Hay marcas extrañas en la pared.");
                    pausa();
                    break;

                case 4:
                    return;

                case 5:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }

    // ==========================================
    // COCINA
    // ==========================================

    public static void cocina() {

        int opcion;

        do {

            mostrarEscena("COCINA",
                    "Una cocina abandonada. Hay cajones abiertos y una mesa.");

            System.out.println("1. Examinar los cajones.");
            System.out.println("2. Examinar debajo de la mesa.");
            System.out.println("3. Examinar el fregadero.");
            System.out.println("4. Volver al recibidor.");
            System.out.println("5. Consultar inventario.");

            opcion = leerOpcion(5);

            switch (opcion) {

                case 1:

                    if (objetosDisponibles.contains("Destornillador")) {

                        interactuarObjeto(
                                "Destornillador",
                                "Encuentras un destornillador oxidado.",
                                "Esta oxidado, pero parece lo bastante resistente para abrir paneles."
                        );

                    } else {

                        mostrarTexto("Ya has revisado los cajones.");

                    }

                    pausa();
                    break;

                case 2:

                    if (objetosDisponibles.contains("Botiquin")) {

                        interactuarObjeto(
                                "Botiquin",
                                "Debajo de la mesa encuentras un botiquin.",
                                "Contiene material medico para curar heridas."
                        );

                    } else {

                        mostrarTexto("Debajo de la mesa ya no hay nada.");

                    }

                    pausa();
                    break;

                case 3:
                    mostrarTexto("El fregadero esta lleno de agua sucia.");
                    mostrarTexto("No parece haber nada util.");
                    pausa();
                    break;

                case 4:
                    return;

                case 5:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }

    // ==========================================
    // BIBLIOTECA
    // ==========================================

    public static void biblioteca() {

        int opcion;

        do {

            mostrarEscena("BIBLIOTECA",
                    "Una enorme biblioteca llena de libros.");

            System.out.println("1. Examinar las estanterias.");
            System.out.println("2. Examinar el escritorio.");
            System.out.println("3. Examinar la caja fuerte.");
            System.out.println("4. Volver al recibidor.");
            System.out.println("5. Consultar inventario.");

            opcion = leerOpcion(5);

            switch (opcion) {

                case 1:

                    mostrarTexto("Encuentras un libro extraño.");
                    mostrarTexto("En su interior aparece un numero: 0427.");

                    codigoDescubierto = true;

                    pausa();
                    break;

                case 2:

                    mostrarTexto("Sobre el escritorio hay una nota.");
                    mostrarTexto("La nota dice: \"El experimento comenzo el dia de la prueba.\"");
                    mostrarTexto("Parece que la caja fuerte necesita una clave de cuatro cifras.");

                    pausa();
                    break;

                case 3:

                    if (!cajaAbierta) {

                        mostrarTexto("La caja fuerte tiene un teclado numerico.");

                        if (codigoDescubierto) {

                            System.out.println("Introduce la contraseña:");
                            String codigo = teclado.nextLine();

                            if (codigo.equals("0427")) {

                                mostrarTexto("La contraseña es correcta.");
                                mostrarTexto("La caja fuerte se abre.");

                                cajaAbierta = true;

                                interactuarObjeto(
                                        "Fusible",
                                        "Dentro de la caja fuerte encuentras un fusible.",
                                        "Parece una pieza necesaria para reparar un generador."
                                );

                            } else {

                                mostrarTexto("La contraseña es incorrecta.");

                            }

                        } else {

                            mostrarTexto("Todavia no conoces la contraseña.");
                            mostrarTexto("Deberias investigar las estanterias.");

                        }

                    } else {

                        mostrarTexto("La caja fuerte esta abierta.");

                    }

                    pausa();
                    break;

                case 4:
                    return;

                case 5:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }

    // ==========================================
    // PASILLO
    // ==========================================

    public static void pasillo() {

        int opcion;

        do {

            mostrarEscena("PASILLO",
                    "Un pasillo largo conecta varias habitaciones.");

            System.out.println("1. Bajar al sotano.");
            System.out.println("2. Entrar en el almacen.");
            System.out.println("3. Ir al laboratorio.");
            System.out.println("4. Volver al recibidor.");
            System.out.println("5. Consultar inventario.");

            opcion = leerOpcion(5);

            switch (opcion) {

                case 1:
                    sotano();
                    break;

                case 2:
                    almacen();
                    break;

                case 3:
                    laboratorio();
                    break;

                case 4:
                    return;

                case 5:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }

    // ==========================================
    // SOTANO
    // ==========================================

    public static void sotano() {

        int opcion;

        do {

            mostrarEscena("SOTANO",
                    "El sotano esta oscuro. Hay un generador y un panel electrico.");

            System.out.println("1. Examinar el generador.");
            System.out.println("2. Examinar el panel electrico.");
            System.out.println("3. Volver al pasillo.");
            System.out.println("4. Consultar inventario.");

            opcion = leerOpcion(4);

            switch (opcion) {

                case 1:

                    if (!generadorActivado) {

                        if (jugador.tieneObjeto("Fusible")) {

                            mostrarTexto("Encuentras un hueco para colocar el fusible.");

                            jugador.usarObjeto("Fusible");

                            generadorActivado = true;

                            mostrarTexto("Colocas el fusible.");
                            mostrarTexto("El generador comienza a funcionar.");
                            mostrarTexto("La mansion vuelve a tener electricidad.");

                        } else {

                            mostrarTexto("El generador no funciona.");
                            mostrarTexto("Le falta un fusible.");

                        }

                    } else {

                        mostrarTexto("El generador ya esta funcionando.");

                    }

                    pausa();
                    break;

                case 2:

                    if (jugador.tieneObjeto("Destornillador")) {

                        mostrarTexto("Utilizas el destornillador para abrir el panel.");
                        mostrarTexto("Dentro encuentras varios cables.");
                        mostrarTexto("Uno de ellos parece estar conectado al laboratorio.");

                    } else {

                        mostrarTexto("El panel esta atornillado.");
                        mostrarTexto("Necesitas un destornillador.");

                    }

                    pausa();
                    break;

                case 3:
                    return;

                case 4:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }

    // ==========================================
    // ALMACEN
    // ==========================================


    public static void almacen() {

        int opcion;

        do {

            mostrarEscena("ALMACEN",
                    "Un almacen lleno de cajas y herramientas antiguas.");

            System.out.println("1. Examinar las cajas.");
            System.out.println("2. Examinar las estanterias.");
            System.out.println("3. Examinar el armario metalico.");
            System.out.println("4. Volver al pasillo.");
            System.out.println("5. Consultar inventario.");

            opcion = leerOpcion(5);

            switch (opcion) {

                case 1:

                    if (objetosDisponibles.contains("Llave pequeña")) {

                        interactuarObjeto(
                                "Llave pequeña",
                                "Entre las cajas encuentras una llave pequeña.",
                                "Es una llave antigua. Podria abrir algun cajon."
                        );

                    } else {
                        mostrarTexto("Ya has revisado todas las cajas.");
                    }

                    pausa();
                    break;

                case 2:
                    mostrarTexto("Las estanterias estan llenas de productos caducados.");
                    pausa();
                    break;

                case 3:

                    if (objetosDisponibles.contains("Arma")) {

                        interactuarObjeto(
                                "Arma",
                                "Abres el armario metalico y encuentras un arma.",
                                "Tiene poca municion, pero puede servir para defenderte."
                        );

                    } else {
                        mostrarTexto("El armario metalico esta vacio.");
                    }

                    pausa();
                    break;

                case 4:
                    return;

                case 5:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }


    // ==========================================
    // LABORATORIO
    // ==========================================


    public static void laboratorio() {

        int opcion;

        if (!generadorActivado) {

            mostrarTexto("La puerta del laboratorio no tiene electricidad.");
            mostrarTexto("Necesitas activar el generador del sotano.");
            pausa();
            return;
        }

        if (!puertaLaboratorioAbierta) {

            if (jugador.tieneObjeto("Tarjeta de seguridad")) {

                mostrarTexto("Pasas la tarjeta por el lector.");
                mostrarTexto("La puerta del laboratorio se desbloquea.");

                puertaLaboratorioAbierta = true;

            } else {

                mostrarTexto("La puerta necesita una tarjeta de seguridad.");
                pausa();
                return;
            }
        }

        if (!criaturaDerrotada) {

            mostrarTexto("Al entrar, una criatura aparece entre las sombras.");
            mostrarTexto("La criatura comienza a acercarse.");

            if (jugador.tieneObjeto("Arma")) {

                mostrarTexto("Levantas el arma y disparas.");
                mostrarTexto("La criatura cae al suelo.");
                mostrarTexto("Has conseguido derrotarla.");

                criaturaDerrotada = true;

            } else {

                mostrarTexto("No tienes nada con lo que defenderte.");
                mostrarTexto("La criatura se abalanza sobre ti.");
                finalMalo();
                return;
            }

            pausa();
        }

        do {

            mostrarEscena("LABORATORIO",
                    "Un laboratorio secreto lleno de ordenadores y jaulas.");

            System.out.println("1. Examinar los ordenadores.");
            System.out.println("2. Examinar las jaulas.");
            System.out.println("3. Examinar la mesa de trabajo.");
            System.out.println("4. Utilizar la salida de emergencia.");
            System.out.println("5. Volver al pasillo.");
            System.out.println("6. Consultar inventario.");

            opcion = leerOpcion(6);

            switch (opcion) {

                case 1:

                    mostrarTexto("Los ordenadores contienen archivos secretos.");
                    mostrarTexto("Descubres que la mansion era un centro de experimentacion.");
                    mostrarTexto("La criatura fue creada por los responsables del proyecto.");

                    pausa();
                    break;

                case 2:

                    if (!cientificoSalvado) {

                        mostrarTexto("Encuentras a un cientifico encerrado en una jaula.");
                        mostrarTexto("Esta herido y necesita ayuda.");

                        if (jugador.tieneObjeto("Botiquin")) {

                            mostrarTexto("¿Quieres entregarle el botiquin?");
                            System.out.println("1. Ayudar al cientifico.");
                            System.out.println("2. Dejarlo encerrado.");

                            int decision = leerOpcion(2);

                            if (decision == 1) {

                                jugador.usarObjeto("Botiquin");
                                cientificoSalvado = true;

                                mostrarTexto("Consigues curar sus heridas.");
                                mostrarTexto("El cientifico te agradece que lo hayas salvado.");
                                mostrarTexto("Te habla de una salida de emergencia.");

                            } else {

                                mostrarTexto("Decides no ayudarlo.");
                                mostrarTexto("El cientifico sigue encerrado.");

                            }

                        } else {

                            mostrarTexto("No tienes material medico para ayudarlo.");
                            mostrarTexto("Necesitas encontrar un botiquin.");

                        }

                    } else {

                        mostrarTexto("El cientifico ya esta a salvo.");
                        mostrarTexto("Te espera junto a la salida de emergencia.");

                    }

                    pausa();
                    break;

                case 3:

                    mostrarTexto("La mesa esta llena de documentos del experimento.");
                    mostrarTexto("Encuentras informes sobre los experimentos de Umbrella.");

                    pausa();
                    break;

                case 4:

                    mostrarTexto("Te acercas a la salida de emergencia.");
                    mostrarTexto("Es tu unica oportunidad de escapar.");

                    if (cientificoSalvado) {
                        finalBueno();
                    } else {
                        finalNeutral();
                    }

                    return;

                case 5:
                    return;

                case 6:
                    jugador.mostrarInventario();
                    pausa();
                    break;
            }

        } while (true);
    }


    // ==========================================
    // INTERACCION CON OBJETOS
    // ==========================================

    public static void interactuarObjeto(
            String objeto,
            String descripcion,
            String textoExamen) {

        if (!objetosDisponibles.contains(objeto)) {

            mostrarTexto("Este objeto ya no esta aqui.");
            return;

        }

        mostrarTexto(descripcion);

        int opcion;

        do {

            System.out.println();
            System.out.println("¿Que quieres hacer?");
            System.out.println();
            System.out.println("1. Recoger " + objeto + ".");
            System.out.println("2. Examinarlo.");
            System.out.println("3. Dejarlo.");

            opcion = leerOpcion(3);

            switch (opcion) {

                case 1:

                    jugador.recogerObjeto(objeto);
                    objetosDisponibles.remove(objeto);
                    return;

                case 2:

                    mostrarTexto(textoExamen);
                    break;

                case 3:

                    mostrarTexto("Dejas el objeto donde estaba.");
                    return;
            }

        } while (true);
    }

    // ==========================================
    // METODOS GENERALES
    // ==========================================

    public static void mostrarEscena(String nombre, String descripcion) {

        System.out.println();
        System.out.println("==================================");
        System.out.println("          " + nombre);
        System.out.println("==================================");

        mostrarTexto(descripcion);
    }

    public static void mostrarTexto(String texto) {

        System.out.println(texto);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static int leerOpcion(int maximo) {

        while (true) {

            System.out.print("Elige una opcion: ");

            String entrada = teclado.nextLine();

            try {

                int opcion = Integer.parseInt(entrada);

                if (opcion >= 1 && opcion <= maximo) {
                    return opcion;
                }

                System.out.println("Opcion no valida. Elige un numero del 1 al " + maximo + ".");

            } catch (NumberFormatException e) {

                System.out.println("Debes introducir un numero.");

            }
        }
    }

    public static void pausa() {

        System.out.println();
        System.out.println("Pulsa ENTER para continuar...");
        teclado.nextLine();
    }

    public static void finalBueno() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             FINAL BUENO");
        System.out.println("==========================================");

        mostrarTexto("Abres la salida de emergencia.");
        mostrarTexto("El cientifico consigue salir contigo.");
        mostrarTexto("A lo lejos se escuchan las sirenas de la policia.");
        mostrarTexto("Has conseguido sobrevivir y salvar a un inocente.");
        mostrarTexto("Pero los documentos revelan que el experimento continua...");
        mostrarTexto("FIN: LA VERDAD SALE A LA LUZ");

        System.exit(0);
    }

    public static void finalNeutral() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("             FINAL NEUTRAL");
        System.out.println("==========================================");

        mostrarTexto("Abres la salida de emergencia y escapas.");
        mostrarTexto("Consigues abandonar la mansion con vida.");
        mostrarTexto("Sin embargo, el cientifico sigue encerrado.");
        mostrarTexto("Nunca sabras que ocurrio con el.");
        mostrarTexto("FIN: SALVATE QUIEN PUEDA");

        System.exit(0);
    }

    public static void finalMalo() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              FINAL MALO");
        System.out.println("==========================================");

        mostrarTexto("La criatura te alcanza.");
        mostrarTexto("Intentas defenderte, pero es demasiado tarde.");
        mostrarTexto("Tu cuerpo cae al suelo del laboratorio.");
        mostrarTexto("La voz de los altavoces vuelve a sonar:");
        mostrarTexto("\"El experimento ha terminado. Sujeto eliminado.\"");
        mostrarTexto("FIN: EL ULTIMO EXPERIMENTO");

        System.exit(0);
    }
}


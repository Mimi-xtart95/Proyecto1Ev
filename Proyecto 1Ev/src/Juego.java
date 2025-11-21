import java.util.Scanner;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;

public class Juego {
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
    static Clip musicaMenu;
    static boolean llave = false;
    static int opcionPersonaje;

    public void main(String[] args) {
        //iniciarMusicaMenu();
        ejecutarMenu();
    }

    public static void mostrarMenu() {
        System.out.println("          ...Cargando...");
        System.out.println(" ⚔️ Bienvenido a LEGENDAR.IA ⚔️");
        System.out.println("     Presiona 0 para Iniciar");
    }

    public void ejecutarMenu() {
        int opcion;
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 0:
                    elegirPersonaje();
                    break;
                default:
                    System.out.println("Estimado Jugador... HEMOS DICHO QUE PRESIONES 0");
                    System.out.println("------------------------------------------------------------");
            }
        }
    }

    public static int leerOpcion() {
        try {
            int op = sc.nextInt();
            sc.nextLine();
            return op;
        } catch (Exception e) {
            sc.nextLine();
            return -1;
        }
    }

    public static void iniciarMusicaMenu() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\Original-Theme.wav";

            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            musicaMenu = AudioSystem.getClip();
            musicaMenu.open(audio);
            musicaMenu.loop(Clip.LOOP_CONTINUOUSLY);
            musicaMenu.start();

            System.out.println("🎵 🎵 🎵 🎵 🎵");

        } catch (Exception e) {
        }
    }

    public int elegirPersonaje() {
        System.out.println("------------------------------------------------------------");
        System.out.println("--ELIGE TU PERSONAJE--");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("------------------------------------------------------------");
        opcionPersonaje = leerOpcion();
        switch (opcionPersonaje) {
            case 1:
                System.out.println("------------------------------------------------------------");
                System.out.println("¡Has elegido el guerrero! ( •̀ㅂ•́)و🗡️");
                System.out.println("------------------------------------------------------------");
                verInventario();
                textoComienzo();
                break;
            case 2:
                System.out.println("------------------------------------------------------------");
                System.out.println("¡Has elegido al mago! (っ-^o^-)っ🪄ﾟ");
                System.out.println("------------------------------------------------------------");
                verInventario();
                textoComienzo();
                break;
            case 2000:
                System.out.println("------------------------------------------------------------");
                System.out.println("¡Has encontrado el Easter Egg y eres un Paladín! [🛡️•̀o•́]r");
                System.out.println("------------------------------------------------------------");
                verInventario();
                textoComienzo();
                break;
            default:
                System.out.println("Eh... Opción no válida");
                elegirPersonaje();
        }
        return opcionPersonaje;
    }

    public static void textoComienzo() {
        System.out.println("                            --COMIENZO--");
        System.out.println("               Te encuentras en un Bosque Magico🌳✨");
        System.out.println("Heroe: Tengo que ir a lo más profundo de este bosque y salvar a mi amad@");
        System.out.println("Heroe: Necesito tomar un camino");
            primeraDecision();
    }

    public static int primeraDecision() {
        System.out.println("Toma un camino");
        System.out.println("⬅️1. Izquierda | 2. Derecha➡️");
        int decision;
        decision = leerOpcion();
        if (decision == 1) {
            System.out.println("------------------------------------------------------------");
            System.out.println("¡Has elegido el camino izquierdo!");
            System.out.println("------------------------------------------------------------");
            System.out.println("A lo lejos divisas una silueta conocida, un recuerdo de tu pasado, por lo que decides acercarte.");
            System.out.println("Un gitano comerciante de nombre Aníd te ofrece la solución a todos tus problemas.");
            System.out.println("------------------------------------------------------------");
            System.out.println("Tienes 2 opciones");
            System.out.println("1. Comprar 💰\n2. Atacar 👊");
            encuentroDani();
        } else if (decision == 2) {
            System.out.println("------------------------------------------------------------");
            System.out.println("¡Has elegido el camino derecho!");
            System.out.println("------------------------------------------------------------");
            System.out.println("Te has encontrado con un enemigo 🧌...");
            System.out.println("Heroe: Este enemigo luce formidable...¿Qué debería hacer?");
            System.out.println("1. Atacar 👊\n2. Huir🏃‍♂️‍➡️");
            int decision2;
            decision2 = leerOpcion();
            if (decision2 == 1) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Has atacado al enemigo");
                System.out.println("------------------------------------------------------------");
                systemCombat();
            } else if (decision2 == 2) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Has huido");
                System.out.println("------------------------------------------------------------");
                System.out.println("Al salir corriendo caes en un agujero y mueres");
                gameOver();
            } else {
                System.out.println("Tengo un enemigo frente a mi, no puedo hacer eso en este momento.");
            }
        } else if (decision == 9) {
                verInventario();
        } else {
            System.out.println("Algo no me permite ir en esa dirección.");
            primeraDecision();
        }
        return decision;
    }

    public static int encuentroDani() {
        int encuentro;
        encuentro = leerOpcion();
        if (encuentro == 1) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Le dices al gitano que deseas comprar el objeto");
            System.out.println("------------------------------------------------------------");
            System.out.println("Lamentablemente los desarrolladores no han implementado un sistema de intercambio\npor lo que procedes a robarle y salir corriendo antes de que pueda reaccionar.");
            System.out.println("JÓDETE ANÍD");
            recogerLlave();
        } else if (encuentro == 2) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Decides atacar al gitano, sin embargo su navaja es más rápida que tu espada.");
            gameOver();
        }
        return encuentro;
    }

    public static void recogerLlave() {
        System.out.println("------------------------------------------------------------");
        llave = true;
        System.out.println("Ahora tienes la llave. 🗝️");
        verInventario();
        cruzarPantano();
    }

    public static void opcionesCastillo(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Continuas caminando hasta llegar al castillo...");
        System.out.println("...");
        System.out.println("Pruebas la llave en la puerta del castillo 🏰");
        System.out.println("Eliges 1 o 2 para probar la llave");
        int pruebaLlave;
        pruebaLlave = leerOpcion();
        if (pruebaLlave == 1) {
            System.out.println("------------------------------------------------------------");
            System.out.println("La llave funciona y puedes entrar al castillo 🏰");
            System.out.println("La puerta del castillo se abre y puedes ver dentro dos figuras");
            System.out.println("Puedes ver a una princesa 👸🏼 y un dragón 🐲");
            System.out.println("Tienes varias opciones...");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Ataca a la princesa");
            System.out.println("2. Salva a la princesa");
            System.out.println("3. Ataca al dragón");
            System.out.println("4. Salva al dragón");
            int opcion;
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("¡Has hecho bien en atacarla, era una villana!");
                    gamePased();
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("La princesa te envenena y mueres.");
                    gameOver();
                    break;
                case 3:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("El dragón, que era tu verdadero amor, muere y decides suicidarte.");
                    gameOver();
                    break;
                case 4:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("¡Salvas a tu amor verdadero y vivís una vida maravillosa!");
                    gamePased();
                    break;
            }
        } else if (pruebaLlave == 2) {
            System.out.println("La llave no funciona... ❌🗝️");
            System.out.println("Te encuentras muy cansado después de todo este largo viaje y decides suicidarte ☠️");
            gameOver();
        }

    }

    public static void systemCombat() {
        int dado = r.nextInt(1, 7);
        if (dado == 1) {
            System.out.println("El dado del destino ha sacado un: ["+dado+"]");
            System.out.println("Lanzas un potente ataque al enemigo💢!");
            System.out.println("...");
            System.out.println("...lastimosamente, la criatura ha esquivado tu ataque");
            System.out.println("La criatura te ha pegado una paliza 🪦");
            gameOver();
        } else if (dado>1) {
            System.out.println("El dado del destino ha sacado un: ["+dado+"]");
            System.out.println("Lanzas un potente ataque al enemigo💢!");
            System.out.println("...");
            System.out.println("La criatura ha recibido un ataque fatal");
            System.out.println("Ésta cae derrotada🪦");
            System.out.println("La criatura ha soltado una llave! 🗝️");
            System.out.println("Decides recogerla y continuar con tu camino.");
            recogerLlave();
        }
    }

    public static void cruzarPantano(){
        System.out.println("Sigues caminando y te encuentras un patano");
        System.out.println("Tienes 3 opciones: \n1.Rodear\n2.Nadar🏊\n3.Balancearse en la liana");
        System.out.println("¿Qué haces?");
        int opcion;
        opcion = leerOpcion();
        switch (opcion) {
            case 1:
                System.out.println("------------------------------------------------------------");
                System.out.println("Has intentado rodearlo y has muerto deshidratado☠️");
                gameOver();
                break;
            case 2:
                System.out.println("------------------------------------------------------------");
                System.out.println("Has intentado nadar en el pantano");
                System.out.println("------------------------------------------------------------");
                System.out.println("Algo toca tu pierna...es un cocodrilo🐊");
                System.out.println("Te come hasta el último hueso 🦴");
                gameOver();
                break;
            case 3:
                System.out.println("------------------------------------------------------------");
                System.out.println("Te sostienes fuerte de la liana...");
                System.out.println("Agarras impulso...");
                System.out.println("Y te balanceas");
                System.out.println("------------------------------------------------------------");
                System.out.println("¡Lograste pasar el pantano! ");
                opcionesCastillo();
                break;
        }
    }

    public static void verInventario(){
        System.out.println("¿Quieres ver tu inventario? Entonces presiona 9.\n Si no, presiona cualquier tecla.");
        int inventario;
        inventario = leerOpcion();
        if (inventario == 9) {
            System.out.println("------------------------------------------------------------");
            System.out.println("          --INVENTARIO--");
            System.out.println("------------------------------------------------------------");
            if (opcionPersonaje == 1) {
                System.out.println("Espada\nEscudo");
                if((opcionPersonaje == 1 && llave == true)){
                    System.out.println("Llave\n");
                }
            } else if (opcionPersonaje == 2) {
                System.out.println("Varita\nLibro de hechizos");
                if((opcionPersonaje == 2 && llave == true)){
                    System.out.println("Llave\n");
                }
            } else if (opcionPersonaje == 2000) {
                System.out.println("Lanza\nArmadura");
                if((opcionPersonaje == 2000 && llave == true)){
                    System.out.println("Llave\n");
                }
            }
        }
    }

    public static void gameOver() {
        System.out.println("------------------------------------------------------------");
        System.out.println("\n        ☠️ GAME OVER ☠️");
        System.out.println("        ¡Gracias por jugar!\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("  Presiona 0 para volverlo a intentar");
        int fin;
        fin = leerOpcion();
        if (fin == 0) {
        }else{
            System.exit(0);
        }
    }

    public static void gamePased(){
        System.out.println("------------------------------------------------------------");
        System.out.println("\n        🎉 HAS GANADO 🎉");
        System.out.println("         ¡Gracias por jugar!\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("   Presiona 0 si quieres volver a jugar");
        int fin;
        fin = leerOpcion();
        if (fin == 0) {
        }else{
            System.exit(0);
        }
    }
}
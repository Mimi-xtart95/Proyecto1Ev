import java.util.Scanner;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;

public class Juego {
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
    static Clip musicaMenu;
    static boolean llave = false;
    static boolean pocion = false;
    static boolean amuleto = false;
    static int opcionPersonaje;
    public static int PV;
    public static int dmg;
    public static int decision;

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

    public void elegirPersonaje() {
        System.out.println("------------------------------------------------------------");
        System.out.println("--ELIGE TU PERSONAJE--");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Helicóptero Westland WAH-64D Apache Longbow");
        System.out.println("------------------------------------------------------------");
        opcionPersonaje = leerOpcion();
        switch (opcionPersonaje) {
            case 1:
                guerrero();
                verInventario();
                textoComienzo();
                break;
            case 2:
                mago();
                verInventario();
                textoComienzo();
                break;
            case 3:
                System.out.println("Te has transformado en un objeto sin consciencia propia\npor lo que eres incapaz de tomar decisiones que te guíen\nal final de este juego sin un piloto y estamos varios siglos\npor detrás antes de que aparezca el primero.");
                gameOver();
                break;
            case 2000:
                paladin();
                verInventario();
                textoComienzo();
                break;
            default:
                System.out.println("Eh... Opción no válida");
                elegirPersonaje();
        }
    }

    public void guerrero() {
        System.out.println("------------------------------------------------------------");
        System.out.println("¡Has elegido el guerrero! ( •̀ㅂ•́)و🗡️");
        System.out.println("------------------------------------------------------------");
        PV = 100;
        dmg = 10;
        mostrarHUD("Guerrero ( •̀-•́)و🗡️          ", PV, dmg);
    }

    public void mago() {
        System.out.println("------------------------------------------------------------");
        System.out.println("¡Has elegido al mago! (っ-^o^-)っ🪄ﾟ");
        System.out.println("------------------------------------------------------------");
        PV = 75;
        dmg = 20;
        mostrarHUD("Mago (っ-^o^-)っ🪄ﾟ          ", PV, dmg);
    }

    public void paladin() {
        System.out.println("------------------------------------------------------------");
        System.out.println("¡Has encontrado el Easter Egg y eres un Paladín! [🛡️•̀o•́]r");
        System.out.println("------------------------------------------------------------");
        PV = 120;
        dmg = 25;
        mostrarHUD("Paladín [🛡️•̀o•́]r            ", PV, dmg);
    }

    public void mostrarHUD(String clase, int PV, int dmg) {
        System.out.println("┌─────────────────────────────┐");
        System.out.printf("│ %-20s│\n", clase);
        System.out.printf("│ PV: %-3d ❤️ / Daño: %-3d      │\n", PV, dmg);
        System.out.println("└─────────────────────────────┘");

    }

    public static void textoComienzo() {
        System.out.println("                            --COMIENZO--");
        System.out.println("               Te encuentras en un Bosque Magico🌳✨");
        System.out.println("Héroe: Tengo que ir a lo más profundo de este bosque y salvar a mi amad@.");
        System.out.println("Héroe: Necesito tomar un camino.");
        primeraDecision();
    }

    public static class Enemigo {
        String nombre;
        int PV;
        int dmg;

        public Enemigo(String nombre, int PV, int dmg) {
            this.nombre = nombre;
            this.PV = PV;
            this.dmg = dmg;
        }
    }

    static Enemigo[] enemigo = {
            new Enemigo("Orco 🧌", 50, 10),
            new Enemigo("JOMA 🐍", 100, 15),
            new Enemigo("SudoSu 💤", 150, 20),
            new Enemigo("Aníd", 200, 30),
            new Enemigo("Princesa", 1, 5)
    };

    public static void systemCombat(Enemigo enemigo) {
        System.out.println("Te enfrentas a " + enemigo.nombre);

        while (enemigo.PV > 0 && PV > 0) {

            System.out.println("PV enemigo: " + enemigo.PV + " 💀" + " | PV PJ: " + PV + "❤️");
            System.out.println("Elige acción:");
            System.out.println("1. Atacar");
            System.out.println("2. Bloquear");

            int enemigoAccion = r.nextInt(1,3); // 1 bloquea, 2 ataca
            int accionpj = leerOpcion();

            if (accionpj == 1) {

                if (enemigoAccion == 1) {
                    System.out.println(enemigo.nombre + " bloquea tu ataque.");
                    System.out.println("Tu golpe no consigue atravesar su guardia (nenita).");

                } else {
                    enemigo.PV -= dmg;
                    System.out.println("¡Atacas al enemigo por " + dmg + " puntos!");
                }

                if (enemigo.PV <= 0) {
                    System.out.println("¡Has derrotado a " + enemigo.nombre + "! 🪦");
                    if (pocion == true){
                        System.out.println("Pulsa 1 para tomar poción");
                        int opcion;
                        opcion = leerOpcion();
                        if (opcion == 1) {
                            PV = PV+100;
                            pocion = false;
                            System.out.println("Tus PV han aumentado a: " + PV);
                            verInventario();
                        }
                    }
                    continuarHistoria();
                    break;
                }
            }

            else if (accionpj == 2) {

                if (enemigoAccion == 1) {
                    System.out.println("Ambos os ponéis en guardia. Nadie se hace daño (miedicas).");
                } else {
                    int danoRecibido = 0;
                    PV -= danoRecibido;
                    System.out.println("Bloqueas el ataque y te hace " + danoRecibido + " puntos de daño.");
                }
            }

            else {
                System.out.println("Acción no válida.");
                continue;
            }
            if (enemigoAccion == 2 && accionpj != 2) { // enemigo ataca y jugador NO bloquea
                PV -= enemigo.dmg;
                System.out.println(enemigo.nombre + " te ataca por " + enemigo.dmg + " puntos.");
            }
                if (PV <= 0) {
                System.out.println("Has sido derrotado por " + enemigo.nombre + "... 🪦");
                gameOver();
                break;
                }
        }
    }

    public static void continuarHistoria() {
        if (enemigo[0].PV==0 && enemigo[1].PV>0 && enemigo[2].PV>0 && enemigo[3].PV>0 && enemigo[4].PV>0) {
            preCruzarPantano();
        } else if (enemigo[1].PV==0 && enemigo[2].PV>0 && enemigo[3].PV>0 && enemigo[4].PV>0) {
            encuentroPrisioneros();
        } else if (enemigo[2].PV==0 && enemigo[3].PV>0 && enemigo[4].PV>0) {
            //encuentroEstafador();
        } else if (enemigo[3].PV==0 && enemigo[4].PV>0) {
            if(decision == 1){
            //combate con el puto gitano
            }
        }else if (enemigo[4].PV>0){
            //Princesa
        }
    }
    public static void primeraDecision() {
        System.out.println("Toma un camino");
        System.out.println("⬅️1. Izquierda | 2. Derecha➡️");
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
            System.out.println("1. Luchar 👊\n2. Huir🏃‍♂️‍➡️");
            int decision2;
            decision2 = leerOpcion();
            if (decision2 == 1) {
                System.out.println("------------------------------------------------------------");
                System.out.println("¡Has entrado en combate!");
                System.out.println("------------------------------------------------------------");
                Enemigo Orco = enemigo[0];
                systemCombat(Orco);
            } else if (decision2 == 2) {
                System.out.println("------------------------------------------------------------");
                System.out.println("¡Has huido!");
                System.out.println("------------------------------------------------------------");
                System.out.println("Al salir corriendo caes en un agujero y mueres.");
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
    }

    public static void encuentroDani() {
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
    }

    public static void recogerLlave() {
        System.out.println("------------------------------------------------------------");
        llave = true;
        System.out.println("Ahora tienes la llave. 🗝️");
        verInventario();
        cruzarPantano();
    }

    public static void opcionesCastillo() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Continuas caminando hasta llegar al castillo...");
        System.out.println("...");
        System.out.println("El imponente castillo de seis pisos se alza ante ti, un monolito oscuro y silencioso.");
        System.out.println("Ante ti, te encuentras una puerta antigua.");
        System.out.println("Pruebas la llave en la puerta del castillo 🏰");
        System.out.println("Eliges 1 o 2 para probar la llave.");
        int pruebaLlave;
        pruebaLlave = leerOpcion();
        if (pruebaLlave == 1) {
            System.out.println("------------------------------------------------------------");
            System.out.println("La llave funciona y puedes entrar al castillo 🏰");
            llave = false;
            opcionesprimerPiso();
        } else if(pruebaLlave == 2){
        System.out.println("La llave no funciona... ❌🗝️");
        System.out.println("Te encuentras muy cansado después de todo este largo viaje y decides suicidarte ☠️");
        gameOver();
    }
        }

    public static void opcionesprimerPiso() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Al entrar, un escalofrío te recorre la espalda, no solo por el frío, sino por el peso de tu deseo.");
        System.out.println("El aire dentro es denso, cargado con el olor a moho, miedo y una magia ancestral maligna.");
        System.out.println("Tu corazón late con una mezcla de terror y una inquebrantable determinación de rescatar a tu amad@.");
        System.out.println("Decides subir al siguiente piso, sin saber que te encontrarás.");
        System.out.println("Presiona 0 para subir al siguiente piso.");
        int decision;
        decision = leerOpcion();
        if (decision == 0) {
        System.out.println("Te diriges hacia el siguiente piso");
        opcionessegundoPiso();
        }
    }
    public static void opcionessegundoPiso() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Al subir a la siguiente planta, te encuentras un cofre antiguo");
        System.out.println("Decides abrirlo");
        System.out.println("----------------------------------------------------------");
        recogerLoot();
        encuentroJoma();
    }

    public static void recogerLoot() {
        pocion = true;
        System.out.println("¡Has encontrado una poción!");
        amuleto = true;
        System.out.println("¡Y también un amuleto!");
        System.out.println("Sin más que hacer, decides subir al siguiente piso");
        verInventario();
    }

    public static void preCruzarPantano() {
        System.out.println("La criatura ha soltado una llave! 🗝️");
        System.out.println("Decides recogerla y continuar con tu camino.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Sigues caminando y te encuentras un patano");
        cruzarPantano();
    }

    public static void cruzarPantano(){
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
                System.out.println("Algo toca tu pierna...es un cocodrilo🐊!");
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
            default:
                System.out.println("Opción, no válida.");
                cruzarPantano();
                break;
        }
    }

    public static void verInventario() {
        System.out.println("¿Quieres ver tu inventario? Entonces presiona 9.\nSi no, presiona cualquier tecla.");
        int inventario;
        inventario = leerOpcion();
        if (inventario == 9) {
            System.out.println("------------------------------------------------------------");
            System.out.println("          --INVENTARIO--");
            System.out.println("------------------------------------------------------------");
            if (opcionPersonaje == 1) {
                System.out.println("Espada\nEscudo");
                if ((opcionPersonaje == 1 && llave == true)) {
                    System.out.println("Llave 🗝️\n");
                } else if ((opcionPersonaje == 1 && pocion == true && amuleto == true)) {
                    System.out.println("Poción ❤️\nAmuleto ✨");
                } else if ((opcionPersonaje == 1 && amuleto == true)) {
                    System.out.println("Amuleto ✨");
                }
            }

            if (opcionPersonaje == 2) {
                System.out.println("Varita\nLibro de hechizos");
                if ((opcionPersonaje == 2 && llave == true)) {
                    System.out.println("Llave 🗝️\n");
                } else if ((opcionPersonaje == 2 && pocion == true && amuleto == true)) {
                    System.out.println("Poción ❤️\nAmuleto ✨");
                } else if ((opcionPersonaje == 2 && amuleto == true)) {
                    System.out.println("Amuleto ✨");
                }
            }

            if (opcionPersonaje == 2000) {
                System.out.println("Lanza\nArmadura");
                if ((opcionPersonaje == 2000 && llave == true)) {
                    System.out.println("Llave 🗝️\n");
                } else if ((opcionPersonaje == 2000 && pocion == true && amuleto == true)) {
                    System.out.println("Poción ❤️\nAmuleto ✨");
                } else if ((opcionPersonaje == 2000 && amuleto == true)) {
                    System.out.println("Amuleto ✨");
                }
            }
        }
    }
    public static void encuentroJoma(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Al subir al piso 3 te encuentras con un enemigo sorprendente,\nes una serpiente humanoide parece muy potente.");
        System.out.println("- ¿Qué hacesss aquí humano?");
        System.out.println("- ¡Venir a rescatar a mi amad@, y nada me va a detener!");
        System.out.println("------------------------------------------------------------");
        Enemigo JOMA = enemigo[1];
        systemCombat(JOMA);
    }
    public static void encuentroPrisioneros(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Nuestro héroe al subir al piso 4 se ha encontrado una celda\ncon 4 prisioneros, 3 hombres y una mujer, están en un estado\nbastante lamentable.");
        System.out.println("Alaric:\n- ¡No sigas adelante, te va a ocurrir como a nosotros, o peor, como a los antiguos guerreros!");
        System.out.println("Lothar:\n- ¡Ah, Héroe, campeón de gestas y andanzas! Si acaso en vuestro zurrón o bolsa encontrasteis un cachivache,\nuna reliquia o un artilugio que al mundo pueda silenciar con su magia... \n¡Os imploro, sí, os conjuro a usarlo sin dilación!");
        System.out.println("-¡El silencio es oro, y más si la aventura os aguarda, oh, mi glorioso patán!");
        System.out.println("Mirelda:\n- ¡Por fin, una cara que no pertenece a un carcelero! Dime, viajero...\n¿Acaso el sol sigue tejiendo oro en los telares de la ciudad?\nMi corazón está tan gastado como mis dedos sin arcilla. Sácame de esta piedra,\nque aún tengo diseños por cincelar y el mundo espera mis manos");
        System.out.println("Mordred:\n- Mis ojos, acostumbrados a la penumbra, apenas os distinguen,\nmas mi espíritu reconoce un atisbo de esperanza... o quizás, el último engaño antes del olvido.");
        System.out.println("Héroe:\n- Tranquilos amigos, volveré a por vosotros en cuánto esta aventura termine, y os ayudaré a volver con vuestras familias.");
        System.out.println("------------------------------------------------------------");
    }
    public static void encuentroSudosu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Al seguir adelante nuestro héroe llega al piso 4, y en el fondo divisa un ente, como un espectro del pasado.");
        System.out.println("SudoSu:\n- ¿Qué haces aquí escoria? ¡Haré que pases a ser una de mis figuras de guerreros antiguos!");
        System.out.println("Héroe:\n- ¡Eso nunca pasará!");
        //Añadir ataque de somnolencia
        //Añadir uso de "tapones o similar"
        //Añadir ataque de lanzamiento de figuras de guerreros antiguos
        //Añadir ataque final del héroe
        System.out.println("------------------------------------------------------------");
    }

public static void opcionesFinal () {
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
}
    public static void gameOver() {
        System.out.println("------------------------------------------------------------");
        System.out.println("\n        ☠️ GAME OVER ☠️");
        System.out.println("       ¡Gracias por jugar!\n");
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
import javax.sound.sampled.*;
import java.io.File;

public class Audio {
    static Clip musicaMenu;
    static Clip sonidoCombat;
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
    public static void sonidoPantano() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\pantano_5seg.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }
    public static void sonidoCastillo() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\creepy-castle-door.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }
    public static void sonidoCombate() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\combate.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            sonidoCombat = AudioSystem.getClip();
            sonidoCombat.open(audio);
            sonidoCombat.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    sonidoCombat.close();
                }
            });
            sonidoCombat.start();
        } catch (Exception e) {
        }
    }
    public static void sonidoCaminar() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\walking-woods.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }
    /*public static void abrirLlave() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\abrir-llave.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }*/
    public static void subirEscaleras() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\subir-escaleras.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }
    public static void sonidoPrision() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\prisioneros.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }
    public static void ataqueGitano() {
        try {
            String ruta = "C:\\Users\\mirem\\IdeaProjects\\Proyecto 1Ev\\ataque-gitano.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        } catch (Exception e) {
        }
    }
}
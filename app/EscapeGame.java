package app;

import model.Hero;
import model.HTWRoom;
/**
 * Diese Klasse definiert, ob das Spiel läuft oder beendet worden ist, sowie auch diverse andere Abläufe, die im Hintergrund laufen.
 * @author bengoldgamer
 * @auhtor tomski912
 */
public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[3];
    private boolean gameRunning = true;
    private boolean gameFinished = false;

    /**
     * Erstellt eine neue Instanz des Spiels und initialisiert den Helden.
     */
    public EscapeGame() {
        this.hero = new Hero();
    }

    /**
     * Prüft, ob das Spiel aktuell läuft.
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Setzt den Status des Spiels.
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    /**
     * Prüft, ob das Spiel erfolgreich beendet wurde.
    */
    public boolean isGameFinished() {
        return gameFinished;
    }

    /**
     * Setzt den Status, ob das Spiel beendet wurde.
     */
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    /**
     * Gibt der Konsole aus, ob das Spiel läuft oder beendet ist. 
     */
    public void run() {
        System.out.println("The game has started. Or not?");
    }

    /**
     * Gibt den Helden zurück.
     */
    public Hero getHero() {
        return hero;
    }
}

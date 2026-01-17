package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Diese Klasse führt das Spiel aus.
 * @author bengoldgamer
 + @author tomski912
 */
public class EscapeApp {

    public static final String SAVE_FILE_NAME = "save";
    private EscapeGame game;
    private boolean gameRunning = true;

    /**
     * Der Einstiegspunkt der Anwendung.
     * Initialisiert die App und startet die Hauptschleife.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the HTW escape");
        System.out.println("========================================\n");

        EscapeApp app = new EscapeApp();

        while (true) {
            app.showMainMenu();
            String choice = app.readUserInput();
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }

    /**
     * Zeigt das Hauptmenü mit den verfügbaren Optionen auf der Konsole an.
     */
    private void showMainMenu() {
        System.out.println("You're in the main menu");
        System.out.println("What do you want to do next?");
        System.out.println("(1) Start new game");

        if (isGameRunning()) {
            System.out.println("(2) Resume game");
        }

        if (hasSavedGame()) {
            System.out.println("(3) Load game");
        }

        if (isGameRunning()) {
            System.out.println("(4) Save game");
        }

        if (hasSavedGame()) {
            System.out.println("(5) Delete game");
        }
        System.out.println("(6) Quit");
        System.out.println("");
        System.out.println("Please choose a number between 1 and 6: ");
    }

    /**
     * Liest eine Zeile von der Standardeingabe (Konsole).
     * @return Die eingelesene Zeichenkette.
     */
    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // TBD
        return userInput;
    }

    /**
     * Verarbeitet die Benutzereingabe aus dem Hauptmenü und ruft entsprechende Methoden auf.
     * @param input Die Eingabe des Benutzers.
     */
    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
                if (isGameRunning()) {
                    this.resumeGame();
                } else {
                    System.out.println("Invalid input. Please choose a correct number");
                }
                break;
            case "3":
                if (hasSavedGame()) {
                    this.loadGame();
                } else {
                    System.out.println("Invalid input. Please choose a correct number");
                }
                break;
            case "4": 
                if (isGameRunning()) {
                    this.saveGame();
                } else {
                    System.out.println("Invalid input. Please choose a correct number");
                }
                break;
            case "5": 
                if (hasSavedGame()) {
                    this.deleteGame();
                } else {
                    System.out.println("Invalid input. Please choose a correct number");
                }
                break;
            case "6":
                System.out.println("Quitting the game. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number between 1 and 6");
                break;
        }
    }

    /**
     * Startet ein neues Spiel.
     */
    private void startGame() {
        this.game = new EscapeGame();
        resumeGame();
    }

    /**
     * Setzt das aktuelle Spiel fort und startet die Spielschleife.
     */
    private void resumeGame() {
        this.game.setGameRunning(true);
        this.game.run();
    }

    /**
     * Löscht die gespeicherte Spielstanddatei, falls vorhanden.
     */
    private void deleteGame() {
        if (new File(SAVE_FILE_NAME).delete()) {
            System.out.println("Game deleted!");
        }
    }

    /**
     * Speichert den aktuellen Spielstand in eine Datei.
     */
    private void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (Exception ex) {
            System.err.println("Something went wrong while saving the game: " + ex.getMessage());
            return;
        }
        System.out.println("Game saved!");
    }

    /**
     * Lädt einen gespeicherten Spielstand aus einer Datei.
     */
    private void loadGame() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.game = (EscapeGame) ois.readObject();
            System.out.println("Game loaded!");
        } catch (Exception ex) {
            System.err.println("Something went wrong while loading the game: " + ex.getMessage());
        }
    }

    /**
     * Prüft, ob aktuell eine Spielinstanz existiert.
     * @return true, wenn eine Spielinstanz existiert, sonst false.
     */
    private boolean isGameRunning() {
        return game != null;
    }

    /**
     * Prüft, ob das aktuelle Spiel beendet ist.
     * @return true, wenn das Spiel beendet ist, sonst false.
     */
    private boolean isGameFinished() {
        return game != null && game.isGameFinished();
    }

    /**
     * Prüft, ob das Spiel gespeichert wurde.
     * @return true, wenn eine Speicherdatei existiert, sonst false.
     */
    private boolean hasSavedGame() {
        return new File(SAVE_FILE_NAME).exists();
    }

}

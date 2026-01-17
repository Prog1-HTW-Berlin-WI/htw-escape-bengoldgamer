package app;

import model.HTWRoom;
import model.Hero;
import java.util.Scanner;

/**
 * Diese Klasse definiert, ob das Spiel läuft oder beendet worden ist, sowie auch diverse andere Abläufe, die im Hintergrund laufen.
 * @author bengoldgamer
 * @author tomski912
 */
public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[3];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    private int currentRound = 1;
    private static final int MAX_ROUNDS = 24;


    /**
     * Erstellt eine neue Instanz des Spiel und initialisiert den Helden.
     */
    public EscapeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Enter your hero's name:");
        String heroName = scanner.nextLine();

        while (heroName.isEmpty()){
            System.out.println("Hero name cannot be empty. Please enter a name:");
            heroName = scanner.nextLine();
        }
        
        this.hero = new Hero(heroName);
        System.out.println("Welcome, " + heroName + "! The HTW is expecting you...");
        System.out.println("[Press Space to continue]");
        scanner.nextLine();
        System.out.println("========================================");
        showGameMenu();
    }

    /**
     * Prüft, ob das Spiel aktuell läuft.
     * @return true, wenn das Spiel läuft, sonst false.
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Setzt den Status des Spiels.
     * @param gameRunning true, wenn das Spiel läuft, sonst false.
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    /**
     * Prüft, ob das Spiel erfolgreich beendet wurde.
     * @return true, wenn das Spiel beendet wurde, sonst false.
    */
    public boolean isGameFinished() {
        return gameFinished;
    }

    /**
     * Setzt den Status, ob das Spiel beendet wurde.
     * @param gameFinished true, wenn das Spiel auf finished gesetzt worden ist, sonst false.
     */
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    /**
     * Gibt der Konsole aus, ob das Spiel läuft oder beendet ist. 
     */
    public void run() {
        System.out.println("The game has started. Or not?");

        Scanner scanner = new Scanner(System.in);

        while (gameRunning && !gameFinished && currentRound <= MAX_ROUNDS) {
            showGameMenu();
            String input = scanner.nextLine();
            handleGameMenuInput(input);
        }

        if (currentRound > MAX_ROUNDS && !gameFinished) {
            handleTimeLimit();
        }
    }

    /**
     * Zeig das Spielmenü an.
     */
    private void showGameMenu() {
        System.out.println("========================================");
        System.out.println("What would you like to do ?");
        System.out.println("(1) Explore the HTW");
        System.out.println("(2) Check Hero Status");
        System.out.println("(3) Show Signature Sheet");
        System.out.println("(4) Take a rest");
        System.out.println("(5) Quit Game");
        System.out.println("Please choose a number between 1 and 5");
        System.out.println("========================================");
    }

    /**
     * Verarbeitet die Eingabe im Spielmenü.
     * @param input Die Eingabe vom Spieler.
     */
    private void handleGameMenuInput(String input) {
        Scanner scanner = new Scanner(System.in);

        switch (input) {
            case "1":
                exploreHTW();
                break;
            case "2":
                showHeroStatus();
                break;
            case "3":
                showSignatureSheet();
                break;
            case "4":
                takeRest();
                break;
            case "5":
                quitGame();
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number");
                break;
        }
    }

    /**
     * Lässt den Helden die HTW erkunden.
     */
    private void exploreHTW() {
        System.out.println("");
        System.out.println("[Press Space to continue]");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * Zeigt den Status des Helden an.
     */
    private void showHeroStatus() {
        System.out.println("");
        System.out.println("[Press Space to continue]");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * Zeigt den Laufzettel des Helden an.
     */
    private void showSignatureSheet() {
        System.out.println("");
        System.out.println("[Press Space to continue]");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * Lässt den Helden eine Pause machen.
     */
    private void takeRest() {
        System.out.println("");
        System.out.println("[Press Space to continue]");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * Beendet das Spiel.
     */
    private void quitGame() {
        gameRunning = false;
        System.out.println("Quitting the game. See you next time!");
    }

    /**
     * Behandelt das Zeitlimit.
     */
    private void handleTimeLimit() {
        System.out.println("========================================");
        System.out.println("TIME IS UP!");
        System.out.println("Round limit of " + MAX_ROUNDS + " has been reached.");
        System.out.println("Prof. Majuntke appears!");
        System.out.println("\"The Time is up! You failed to escape the HTW!\"");
        System.out.println("The HTW doors are closing forever...");
        System.out.println("YOU LOST! Maybe you can succeed next time!");
        System.out.println("[Press Space to continue]");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        gameRunning = false;
        gameFinished = true;
    }
 
    /**
     * Gibt den Helden zurück.
     * @return das Hero-Objekt.
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * Gibt die aktuelle Runde zurück.
     * @return die aktuelle Runde.
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /**
     * Erhöht die aktuelle Runde um 1.
     */
    public void incrementRound() {
        currentRound++;
    }
}

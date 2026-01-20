package app;

import model.HTWRoom;
import model.Hero;
import model.Alien;
import model.RadioactiveCoffeeSnail;
import model.FriendlyBot;
import model.Lecturer;
import java.util.Scanner;

/**
 * Diese Klasse definiert, ob das Spiel läuft oder beendet worden ist, sowie auch diverse andere Abläufe, die im Hintergrund laufen.
 * @author bengoldgamer
 * @author tomski912
 */
public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[3];
    private final Lecturer[] lecturers = new Lecturer[5];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    private int currentRound = 1;
    private static final int MAX_ROUNDS = 24;


    /**
     * Erstellt eine neue Instanz des Spiel und initialisiert den Helden..
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
        initializeRooms();
        initializeLecturers();


        System.out.println("Welcome, " + heroName + "! The HTW is expecting you...");
        System.out.println("[Press Enter to continue]");
        scanner.nextLine();
        System.out.println("========================================");
    }

    /**
     * Initialisiert die Räume mit Beschreibungen.
     */
    private void initializeRooms() {
        rooms[0] = new HTWRoom("Labor 1", 
         "Neon lights flicker above you. \n" +
         "Workstations stand empty. It smells of\n" +
         "old electronics. Old programming assignments\n" +
         "are still visible on the board.");
        rooms[1] = new HTWRoom("Treppenhaus A",
         "The steps are worn, the echo of your\n" +
         "footsteps reverberates through the stairwell.\n" +
         "Posters for student initiatives hang everywhere.");
        rooms[2] = new HTWRoom("Hörsaal A",
         "Rows of folding desks face a large whiteboard.\n" +
         "Formulas are still visible on the whiteboard.\n");
    }

    /**
     * Initialisiert die Übungsleiter.
     */
    private void initializeLecturers() {
        lecturers[0] = new Lecturer("Frau Safitri");
        lecturers[1] = new Lecturer("Frau Vaseva");
        lecturers[2] = new Lecturer("Herr Poeser");
        lecturers[3] = new Lecturer("Frau Gärtner");
        lecturers[4] = new Lecturer("Herr Gnaoui");
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
        Scanner scanner = new Scanner(System.in);

        int randomRoomIndex = (int) (Math.random() * rooms.length);
        HTWRoom currentRoom = rooms[randomRoomIndex];

        System.out.println("========================================");
        System.out.println("You are exploring the HTW...");
        System.out.println("You have entered: " + currentRoom.getIdentifier() + "!");
        System.out.println(currentRoom.getDiscription());
        System.out.println("\n[1 Round passed. Round: " + currentRound + "/" + MAX_ROUNDS + "]");

        double eventChance = Math.random() * 100;

        if (eventChance < 20) {
            handleUneventful();
        } else if (eventChance < 72) {
            handleAlienEncounter();
        } else {
            handleLecturerEncounter(currentRoom);
        }

        incrementRound();
        hero.resetSmallRest();
    }

    /**
     * Behandelt ein ereignisloses Erkunden.
     */
    private void handleUneventful() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The room is eerily quiet. Nothing happens.");
        System.out.println("Your going back to the main menu.");
        System.out.println("[Press Enter to continue]");
        scanner.nextLine();
    }

    /**
     * Behandelt die Begegnung mit einem Übungsleiter.
     * @param room Der Raum, in dem die Begegnung stattfindet.
     */
    private void handleLecturerEncounter(HTWRoom room) {
        Scanner scanner = new Scanner(System.in);
        
        Lecturer availableLecturer = null;
        for (Lecturer lecturer : lecturers) {
            if (lecturer.isReadytoSign()) {
                availableLecturer = lecturer;
                break;
            }
        }

        if (availableLecturer == null) {
            System.out.println("ENCOUNTER WITH LECTURER");
            System.out.println("Youre encountering a lecturer,");
            System.out.println("but they have already signed your sheet.");
            System.out.println("No new signature can be obtained here.");
            System.out.println("[Press Enter to continue]");
            scanner.nextLine();
            return;
        }

        System.out.println("ENCOUNTER WITH LECTURER");
        System.out.println("You encounter " + availableLecturer.getName() + " in " + room.getIdentifier() + "!");
        System.out.println("Hello there! I gladly sign your sheet.");

        availableLecturer.sign();
        hero.signExerciseLeader(availableLecturer);
        
        System.out.println("You received a signature!");
        System.out.println("[Signatures: " + hero.getSignatureCount() + "/5]");
        System.out.println("[Press Enter to continue]");
        scanner.nextLine();
    }

    /**
     * Behandelt die Begegnung mit einem Alien.
     */
    private void handleAlienEncounter() {
        Scanner scanner = new Scanner(System.in);

        Alien alien;
        double alienType = Math.random();

        if (alienType < 0.5) {
            alien = new RadioactiveCoffeeSnail();
        } else {
            alien = new FriendlyBot();
        }

        System.out.println("ENCOUNTER WITH ALIEN");
        System.out.println("You encounter a " + alien.getName() + "!");
        System.out.println(alien.getGreeting());

        if (alien.isFriendly()) {
            System.out.println("The alien seems friendly and does not want to fight.");
            System.out.println("[Press Enter to continue]");
            scanner.nextLine();
        } else {
            System.out.println("The alien is hostile and attacks you!");
            System.out.println("[Press Enter to continue]");
            scanner.nextLine();
            handleCombat(alien);
        }
    }

    /**
     * Behandelt den Kampf mit einem Alien
     * @param alien Das gegnerische Alien.
     */
    private void handleCombat(Alien alien) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Diese Funktion ist noch nicht implementiert.");
        System.out.println("[Press Enter to continue]");
        scanner.nextLine();
    }

    /**
     * Zeigt den Status des Helden an.
     * Gibt eine Übersicht über Name, Lebenspunkte, Erfahrungspunkt.
     * Die aktuelle Runde und den Stand des Laufzettels. 
     */
    private void showHeroStatus() {
        System.out.println("========================================");
        System.out.println("HERO STATUS");
        System.out.println("Name: " + hero.getName());
        System.out.println("Lifepoints (LP): " + hero.getHealthPoints() + "/50");
        System.out.println("Experiencepoints (EP): " + hero.getExperiencePoints());
        System.out.println("Current round: " + currentRound + "/" + MAX_ROUNDS);
        System.out.println("");
        System.out.println("--- SIGNED EXERCISE LEADERS ---");

        Lecturer[] signedLecturers = hero.getSignedExerciseLeaders();

        for (int i = 0; i < signedLecturers.length; i++) {
            if (signedLecturers[i] != null) {
                System.out.println("[X] " + signedLecturers[i].getName());
            } else {
                System.out.println("[] (not yet received)");
            }
        }

        System.out.println("");
        int signatureCount = hero.getSignatureCount();
        System.out.println("Signatures collected: " + signatureCount + "/5");
        System.out.println("Signatures required: " + (5 - signatureCount) + "/5");

        if (hero.isOperational()) {
            System.out.println("Status: In game");
        } else {
            System.out.println("Status: Incapable of acting");
        }

        System.out.println("========================================");
        System.out.println("[Press Enter to continue]");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * Lässt den Helden eine Pause machen. Dabei gibt es zwei Optionen: 
     * eine kleine Pause (+3LP pro Runde) und eine große Pause (10LP, kostet allerdings eine Runde).
     */
    private void takeRest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("How would you like to rest?");
        System.out.println("Your current HP: " + hero.getHealthPoints() + "/50");
        System.out.println("(1) Small Rest (+3 HP, once per round)");

        if (hero.hasUsedSmallRestThisRound()) {
            System.out.println("   [Already used this round]");
        }

        System.out.println("(2) Long Rest (+10 HP, costs 1 round)");
        String input = scanner.nextLine();

        switch(input) {
            case "1":
                System.out.println();
                handleSmallRest();
                break;
            case "2":
                System.out.println();
                handleLongRest();
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number");
                takeRest();
                break;
            }
        
    }

    /**
     * Behandelt die kleine Pause. (+3 LP)
     */
    private void handleSmallRest() {
        Scanner scanner = new Scanner(System.in);

        if (hero.hasUsedSmallRestThisRound()) {
            System.out.println("You have already used a small rest this round.");
            System.out.println("Returning to the main menu.");
            System.out.println("[Press Enter to continue]");
            scanner.nextLine();
            return;
        }

        int oldHP = hero.getHealthPoints();
        hero.regenerate(false);
        int newHP = hero.getHealthPoints();
        int actualRegen = newHP - oldHP;

        System.out.println("You take a small rest and recover " + actualRegen + " HP.");
        System.out.println("Your current HP: " + newHP + "/50");
        System.out.println("Current Round: " + currentRound + "/" + MAX_ROUNDS);
        System.out.println();
        System.out.println("[Press Enter to continue]");
        scanner.nextLine();
    }

    /**
     * Behandelt die große Pause. (+10 LP)
     */
    private void handleLongRest() {
        Scanner scanner = new Scanner(System.in);

        int oldHP = hero.getHealthPoints();
        hero.regenerate(true);
        int newHP = hero.getHealthPoints();
        int actualRegen = newHP - oldHP;

        System.out.println("You take a long rest and recover " + actualRegen + " HP.");
        System.out.println("Your current HP: " + newHP + "/50");
        System.out.println("You spent one round resting.");

        incrementRound();

        System.out.println("Current Round: " + currentRound + "/" + MAX_ROUNDS);
        System.out.println();

        if (currentRound > MAX_ROUNDS) {
            handleTimeLimit();
            return;
        }

        System.out.println("[Press Enter to continue]");
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
        System.out.println("[Press Enter to continue]");
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

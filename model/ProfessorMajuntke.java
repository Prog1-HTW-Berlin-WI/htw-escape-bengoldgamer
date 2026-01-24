package model;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Repräsentiert Professor Majuntke, die die finale Prüfung durchführt.
 * Sie stellt Multiple-Choice-Fragen zum Thema "Grundlagen der Programmierung" an den Spieler.
 * 
 * @author bengoldgamer
 * @author tomski912
 */
public class ProfessorMajuntke implements Serializable {

    private static final long serialVersionUID = 2L;

    private static final Question[] QUESTIONS = Question.createAllQuestions();

    /**
     * Zeigt die Begrüßung von Professorin Majuntke an.
     */
    public void showIntroduction() {
        System.out.println("========================================");
        System.out.println("ENCOUNTER: PROFESSOR MAJUNTKE");
        System.out.println("========================================");
        System.out.println();
        System.out.println("A woman appears in the main building of the HTW...");
        System.out.println("The woman floats before you, it is Professor Majuntke:");
        System.out.println();
        System.out.println("\"Ah, there you are! You have sought out all my colleagues. Impressive!");
        System.out.println("Now you must answer me a question about Fundamentals of Programming.");
        System.out.println("If you answer correctly, you may leave.\"");
        System.out.println();
    }

    /**
     * Führt die Prüfung durch mit zwei Versuchen.
     * 
     * @param scanner Scanner für Benutzereingaben 
     * @return true wenn bestanden, false wenn durchgefallen
     */
    public boolean conductExam(Scanner scanner) {
        showIntroduction();

        System.out.println("[Press Enter to continue]");
        scanner.nextLine();

        boolean firstAttemptPassed = askQuestion(scanner);
        if (firstAttemptPassed) {
            showVictory();
            return true;
        }

        System.out.println("========================================");
        System.out.println("WRONG!");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Professor Majuntke shakes her head:");
        System.out.println("\"That was incorrect. You have one more chance. Answer carefully.\"");
        System.out.println();
        System.out.println("---SECOND EXAM ATTEMPT---");
        System.out.println();
        System.out.println("[Press Enter to continue]");
        scanner.nextLine();

        boolean secondAttemptPassed = askQuestion(scanner);
        if (secondAttemptPassed) {
            showVictory();
            return true;
        } else {
            showDefeat();
            return false;
        }


    }

    /**
     * Stellt eine zufällige Frage und prüft die Antwort.
     * 
     * @param scanner Scanner für Benutzereingaben.
     * @return true wenn die Antwort korrekt ist, sonst false.
     */
    private boolean askQuestion(Scanner scanner) {
        int randomIndex = (int) (Math.random() * QUESTIONS.length);
        Question question = QUESTIONS[randomIndex];

        System.out.println("========================================");
        System.out.println("EXAM QUESTION");
        System.out.println("========================================");
        System.out.println();
        question.displayQuestion();
        System.out.println();
        System.out.println("Your answer (a, b, c, or d): ");

        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a, b, c, or d:");
            }
        }

        int answerIndex = input.charAt(0) - 'a';

        return question.isCorrect(answerIndex);
    }

    /**
     * Zeigt die Siegesmeldung an. 
     */
    private void showVictory() {
        System.out.println("========================================");
        System.out.println("CORRECT!");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Professor Majuntke smiles:");
        System.out.println("\"Well done! You have answered correctly.");
        System.out.println("You may now leave the HTW. Farewell!\"");
        System.out.println();
        System.out.println("*** YOU WON!!! ***");
        System.out.println();
    }

    /**
     * Zeigt die Niederlagenmeldung an.
     */
    private void showDefeat() {
        System.out.println("========================================");
        System.out.println("WRONG! GAME OVER!");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Professor Majuntke sighs deeply:");
        System.out.println("\"Too bad, too bad! Then you have only only one option left...\"");
        System.out.println();
        System.out.println("She raises her staff and slams it onto the ground.");
        System.out.println();
        System.out.println("\"YOU SHALL NOT PASS!\"");
        System.out.println();
        System.out.println("She gets into her spaceship and flies away, leaving you stranded forever at the HTW!");
        System.out.println();
        System.out.println("*** YOU LOST!!! ***");
        System.out.println();
    }

}

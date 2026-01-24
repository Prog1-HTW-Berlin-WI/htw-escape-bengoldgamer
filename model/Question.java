package model;

import java.io.Serializable;

/**
 * Respräsentiert eine Multipe Choice Frage mit vier Antwortmöglichkeiten.
 * Genau eine Antwort davon ist korrekt.
 * 
 * @author bengoldgamer
 * @author tomski912
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String questionText;
    private final String[] answers;
    private final int correctAnswerIndex;

    /**
     * Konstruktor für eine Multiple-Choice-Frage.
     * 
     * @param questionText Der Text der Frage.
     * @param answer1 Erste Antwortmöglichkeit.
     * @param answer2 Zweite Antwortmöglichkeit.
     * @param answer3 Dritte Antwortmöglichkeit.
     * @param answer4 Vierte Antwortmöglichkeit.
     * @param correctAnswerIndex Der Index der richtigen Antwort (0-3).
     */
    public Question(String questionText, String answer1, String answer2, String answer3, String answer4, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answers = new String[] {answer1, answer2, answer3, answer4};
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * Initialisiert die Mulitiple-Choice-Fragen für die Prüfung.
     * 
     * @return Array mit den drei Fragen. 
     */
    public static Question[] createAllQuestions() {
        Question[] questions = new Question[3];

        questions[0] = new Question(
            "What does the method 'length()' return for a String?",
            "The current position of the string",
            "The number of characters in the string",
            "The first character of the string",
            "The memory size of the string",
            1
        );
        questions[1] = new Question(
            "What is the difference between '==' and 'equals()' for Strings?",
            "'==' compares references, 'equals()' compares content",
            "Both are the same",
            "'equals()' is faster than '=='",
            "'==' compares content, 'equals()' compares references",
            0
        );
        questions[2] = new Question(
            "Which of the following is NOT a valid loop structure in Java?",
            "for loop",
            "while loop",
            "do-while loop",
            "repeat-until loop",
            3
        );

        return questions;
            
    }

    /**
     * Gibt den Fragetext zurück.
     * 
     * @return Der Text der Frage.
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Gibt die Antwortmöglichkeiten zurück.
     * 
     * @return Array mit vier Antwortmöglichkeiten.
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Prüft ob die angegebene Antwort korrekt ist.
     * 
     * @param answerIndex Der Index der gegebenen Antwort (0-3).
     * @return true, wenn die Antwort korrekt ist, sonst false.
     */
    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    /**
     * Gibt die Frage formatiert auf der Konsole aus.
     */
    public void displayQuestion() {
        System.out.println(questionText);
        System.out.println("(a) " + answers[0]);
        System.out.println("(b) " + answers[1]);
        System.out.println("(c) " + answers[2]);
        System.out.println("(d) " + answers[3]);
    }
    
}

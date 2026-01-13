package model;

import java.io.Serializable;

/**
 * @author bengoldgamer
 * @author tomski912
 */
public class Lecturer implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 540082607047283589L;

    private String name;
    private boolean hasSigned;

    /**
     * Erstellt einen neuen Übungsleiter mit dem angegebenen Namen.
     * 
     * @param name Der Name des Übungsleiters.
     */
    public Lecturer(String name) {
        this.name = name;
        this.hasSigned = false;
    }

    /**
     * Erstellt alle 5 Übungsleiter mit Namen.
     * 
     * @return Array mit 5 Übungsleitern.
     */
    public static Lecturer [] createAllLecturers() {
        Lecturer [] lecturers = new Lecturer[5];

        lecturers[0] = new Lecturer(" Frau Safitri");
        lecturers[1] = new Lecturer(" Frau Vaseva");
        lecturers[2] = new Lecturer(" Herr Poeser");
        lecturers[3] = new Lecturer(" Frau Gärtner");
        lecturers[4] = new Lecturer(" Herr Gnaoui");

        return lecturers;
    }


    /**
     * Gibt an, ob der Übungsleiter bereit ist, den Laufzettel zu unterschreiben.
     * In dieser Implementierung ist der Übungsleiter immer bereit, wenn er noch nicht unterschrieben hat.
     * 
     * @return true, wenn bereit zum Unterschreiben, sonst false.
     */
    public boolean isReadytoSign() {
        return !hasSigned;
    }

    /**
     * Setzt hasSigned auf true, setzt damit die Unterschrift des Übungsleiters als erledigt.
     */
    public void sign() {
        this.hasSigned = true;
    }

    /**
     * Gibt den Namen des Übungsleiters zurück.
     * 
     * @return Name des Übungsleiters.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt zurück, ob der Übungsleiter bereits unterschrieben hat.
     * 
     * @return true, wenn der Übungsleiter unterschrieben hat.
     */
    public boolean hasSigned() {
        return hasSigned;
    }
}
package model;

import java.io.Serializable;

/**
 * Repräsentiert einen Raum innerhalb der HTW.
 * @author bengoldgamer
 * @author tomski912
 */
public class HTWRoom implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 9065680017147292999L;

    private String identifier;
    private String description;
    private Lecturer lecturer;

    /**
     * Erstellt einen neuen Raum mit Bezeichner und Beschreibung.
     * 
     * @param identifier Eindeutiger Bezeichner des Raums
     * @param description Textuelle Beschreibung des Raums
     */
    public HTWRoom(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
        this.lecturer = null;
    }

    /**
     * Erstellt einen neuen Raum mit Bezeichner und Beschreibung und Übungsleiter.
     * 
     * @param identifier Eindeutiger Bezeichner des Raums
     * @param description Textuelle Beschreibung des Raums
     * @param lecturer Eindeutiger Bezeichner des Übungsleiter
     */

    public HTWRoom(String identifier, String description, Lecturer lecturer) {
        this.identifier = identifier;
        this.description = description;
        this.lecturer = lecturer;
    }


     /**
     * Initialisiert die Räume mit Beschreibungen.
     */
    public static HTWRoom[] createAllRooms() {

        HTWRoom[] rooms = new HTWRoom[3];

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

        return rooms;
    }

    /**
     * Gibt den eindeutigen Bezeichner des Raums zurück.
     * 
     * @return Der Raumbezeichner
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Gibt die Beschreibung des Raums zurück.
     * 
     * @return Die Raumbeschreibung
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gibt den Übungsgruppenleiter zurück, der sich im Raum aufhält.
     * 
     * @return Der Übungsgruppenleiter oder null, wenn keiner im Raum ist
     */
    public Lecturer getLecturer() {
        return lecturer;
    }

    /**
     * Setzt den Übungsgruppenleiter, der sich im Raum aufhält.
     * 
     * @param lecturer Der Übungsgruppenleiter oder null
     */
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    /**
     * Prüft, ob sich ein Übungsgruppenleiter im Raum befindet.
     * 
     * @return true wenn ein Lecturer vorhanden ist, sonst false
     */
    public boolean hasLecturer(){
        return this.lecturer != null;
    }
}

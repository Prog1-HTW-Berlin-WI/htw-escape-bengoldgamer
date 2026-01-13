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
     * Erstellt einen neuen Raum mit Bezeichner, Beschreibung und Übungsleiter.
     * 
     * @param identifier Eindeutiger Bezeichner des Raums
     * @param description Textuelle Beschreibung des Raums
     * @param lecturer Der Übungsgruppenleiter, der sich in diesem Raum aufhält
     */
    public HTWRoom(String identifier, String description, Lecturer lecturer) {
        this.identifier = identifier;
        this.description = description;
        this.lecturer = lecturer;
    }
    /**
     * Erstellt alle 10 HTW-Räume mit realistischen Beschreibungen.
     * 
     * @return Array mit 10 vordefinierten HTW-Räumen
     */
    public static HTWRoom[] createAllRooms() {
        HTWRoom[] rooms = new HTWRoom[10];

        rooms[0] = new HTWRoom("Labor 1",
            "Neon-Leuchtstoffröhren flackern über dir.\n" +
            "Workstations stehen leer. Hier riecht es nach\n" +
            "Lötmittel und Elektronik. An der Tafel sind\n" +
            "noch alte Programmieraufgaben zu sehen.");

        rooms[1] = new HTWRoom("Treppenhaus A",
            "Das Echo deiner Schritte hallt durch das\n" +
            "leere Treppenhaus. Graffiti an den Wänden\n" +
            "zeigt Formeln und Studentenwitze.");

        rooms[2] = new HTWRoom("Hörsaal A", 
            "Reihen von Klappsitzen erstrecken sich vor dir.\n" +
            "Eine große Leinwand hängt vorne an der Wand.\n" +
            "Der Geruch von Kaffee und alten Lehrbüchern\n" +
            "liegt in der Luft. Hier wurden schon viele Prüfungen geschrieben.");

        rooms[3] = new HTWRoom("Mensa", 
            "Lange Tische und Plastikstühle füllen den Raum.\n" +
            "Die Essensausgabe ist geschlossen, aber der\n" +
            "Geruch von Pommes und Currywurst hängt noch\n" +
            "in der Luft. Tabletts stapeln sich an der Seite.");


        rooms[4] = new HTWRoom("Eingang", 
            "Die große Eingangshalle mit ihren Glastüren.\n" +
            "Normalerweise herrscht ein Durcheinander von Studenten.\n" +
            "Jetzt ist es unheimlich still. Informationstafeln\n" +
            "zeigen den Campus-Plan und Veranstaltungshinweise.");

        rooms[5] = new HTWRoom("Raum 142", 
            "Ein typischer Seminarraum mit Tischen.\n" +
            "Whiteboards an den Wänden sind voll mit\n" +
            "Notizen und Diagrammen. Beamer und Laptop\n" +
            "stehen bereit. Hier finden die Übungsgruppen statt.");

        rooms[6] = new HTWRoom("Innenhof", 
            "Ein kleiner Innenhof mit ein paar Bänken.\n" +
            "Normalerweise treffen sich hier Studenten\n" +
            "in den Pausen. Zigarettenstummel und\n" +
            "Coffee-to-go-Becher liegen herum.");


        rooms[7] = new HTWRoom("WC", 
            "Die Toiletten im ersten Stock. Weiße Fliesen,\n" +
            "summende Ventilatoren und tropfende Wasserhähne.\n" +
            "Der Desinfektionsmittelgeruch ist intensiv.\n" +
            "An den Türen hängen alte Veranstaltungsplakate.");

        rooms[8] = new HTWRoom("Bibliothek", 
            "Endlose Regale voller Bücher und Fachzeitschriften.\n" +
            "Ruhezonen mit Einzelarbeitsplätzen und PCs.\n" +
            "Das Licht ist gedämpft, es riecht nach altem Papier.\n" +
            "Hier verbringen Studenten viele Stunden vor Prüfungen.");


        rooms[9] = new HTWRoom("Keller", 
            "Der Keller der HTW ist dunkel und unheimlich.\n" +
            "Rohre laufen an der Decke entlang, es tropft irgendwo.\n" +
            "Alte Möbel und ausrangierte Technik stapeln sich.\n" +
            "Nur wenige verirren sich hierher.");


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
    public String getDiscription() {
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

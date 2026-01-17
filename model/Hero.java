package model;

import java.io.Serializable;

/**
 * Zeigt den Spielcharakter Hero.
 * Er kann Schaden nehmen, sich regenerieren, kämpfen, fliehen
 * und Unterschriften sammeln.
 * 
 * @author bengoldgamer
 * @author tomski912
 */
public class Hero implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 3578735620108186013L;

    private static final int MAX_HEALTH_POINTS = 50;
    private static final int MAX_SIGNITURES = 5;
    private static final double FLEE_SUCCESS_RATE = 0.42;
    private static final double ATTACK_DAMAGE_MULTIPLIER = 2.3;
    private static final double ATTACK_MISS_RATE = 0.13;
    private static final double ATTACK_CRITICAL_RATE = 0.12;
    private static final int SMALL_REST_REGENERATION = 3;
    private static final int LONG_REST_REGENERATION = 10;

    private String name;
    private int healthPoints;
    private int experiencePoints;
    private Lecturer[] signedExerciseLeaders;
    private boolean hasUsedSmallRestThisRound;

    /**
     * Erstellt einen neuen Hero mit Startwerten:
     * 50 Lebenspunkte, 0 Erfahrungspunkte, leerer Laufzettel.
     */
    public Hero(String name) {
        this.name = name;
        this.healthPoints = MAX_HEALTH_POINTS;
        this.experiencePoints = 0;
        this.signedExerciseLeaders = new Lecturer[MAX_SIGNITURES];
        this.hasUsedSmallRestThisRound = false;
    }

    /**
     * Reduziert die Lebenspunkte um den Wert.
     * Die Lebenspunkte dürfen nicht kleiner als 0 werden.
     * 
     * @param amount Der Schadenswert, um den die Lebenspunkte abgezogen werden.
     */
    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    /**
     * Der Spielcharakter kann eine Verschnaufpause machen.
     * Kleine Pause: +3 Lebenspunkte (einmal pro Runde).
     * Große Pause: +10 Lebenspunkte (dauert eine komplette Runde).
     * Die Lebenspunkte dürfen den Maximalwert von 50 nicht überschreiten.
     * 
     * @param longRest true für große Verschnaufpause, false für kleine
     */
    public void regenerate(boolean longRest) {
        if (longRest) {
            this.healthPoints += LONG_REST_REGENERATION;
            this.hasUsedSmallRestThisRound = false;
        } else {
            if (this.hasUsedSmallRestThisRound == false) {
                this.healthPoints += SMALL_REST_REGENERATION;
                this.hasUsedSmallRestThisRound = true;
            }
        }

        if (this.healthPoints > MAX_HEALTH_POINTS) {
            this.healthPoints = MAX_HEALTH_POINTS;
        }
    }

    /**
     * Fluchtversuch auf Begegnung.
     * Die Flucht gelingt mit einer Wahrscheinlichkeit von 42%.
     * 
     * @return true bei erfolgreicher Flucht, sonst false
     */
    public boolean flee() {
        return Math.random() < FLEE_SUCCESS_RATE;
    }

    /**
     * Angriff auf ein Alien.
     * Grundschaden: experiencePoints * 2,3 + 1.
     * 13% Wahrscheinlichkeit, dass der Angriff verfehlt (Schaden = 0).
     * 12% Wahrscheinlichkeit, dass der Angriff kritisch ist (Schaden wird verdoppelt).
     * 
     * @return Der berechnete Schaden als Ganzzahl
     */
    public int attack() {
        double random = Math.random();

        if (random < ATTACK_MISS_RATE) {
            return 0;
        }

        int damage = (int) (experiencePoints * ATTACK_DAMAGE_MULTIPLIER + 1);

        if (random >= (1.0 - ATTACK_CRITICAL_RATE)) {
            damage *= 2;
        }

        return damage;
    }

    /**
     * Trägt den angegeben Übungsleiter in den nächsten freien Platz
     * des Laufzettels ein. Jeder Übungsgruppenleiter darf nur einmal unterschreiben.
     * 
     * @param lecturer Der Übungsgruppenleiter, der unterschreiben soll
     */
    public void signExerciseLeader(Lecturer lecturer) {
        //Prüft, ob Lecturer schon unterschrieben hat
        for (int i = 0; i < signedExerciseLeaders.length; i++) {
            if (signedExerciseLeaders[i] != null &&
                signedExerciseLeaders[i].getName().equals(lecturer.getName())) {
                return;
            }
        }

        // Ersten freien Platz finden und eintragen
        for (int i = 0; i < signedExerciseLeaders.length; i++) {
            if (signedExerciseLeaders[i] == null) {
                signedExerciseLeaders[i] = lecturer;
                lecturer.sign();
                return;
            }
        }

    }

    /**
     * Gibt die aktuelle Erfahrungspunkte zurück.
     * 
     * @return Die aktuellen Erfahrungspunte
     */
    public int getExperiencePoints() {
        return experiencePoints;
    }

    /**
     * Erhöt die Erfahrungspunkte um den angegeben Wert.
     * 
     * @param experiencePoints Der Wert, um den die Erfahrungspunkte erhöht werde
     */
    public void addExperiencePoints(int experiencePoints) {
        this.experiencePoints += experiencePoints;
    }

    /**
     * Gibt an, ob der Spielcharakter noch handlungsfähig ist.
     * Der Charakter ist betriebsbereit, solange healthPoints größer als 0 sind.
     * 
     * @return true wenn handlungsfähig ist, sonst false
     */
    public boolean isOperational() {
        return this.healthPoints > 0;
    }

    /**
     * Setzt den Namen des Heroes.
     * 
     * @param name Der Name des Heroes
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die aktuellen Lebenspunkte zurück.
     * 
     * @return Die aktuellen Lebenspunkte
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Gibt das Array der unterschriebenen Übungsleiter zurück.
     * 
     * @return Array der Übungsleiter, die unterschrieben haben
     */
    public Lecturer[] getSignedExerciseLeaders() {
        return signedExerciseLeaders;
    }

    /**
     * Gibt die Anzahl der gesammelten Unterschriften zurück.
     * 
     * @return Anzahl der Unterschriften
     */
    public int getSignatureCount() {
        int count = 0;
        for (int i = 0; i < signedExerciseLeaders.length; i++) {
            if (signedExerciseLeaders[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Setzt die Funktion für die kleine Verschnaufpause zurück.
     * Sollte am Anfang jeder neuen runde Aufgerufen werden.
     */
    public void resetSmallRest() {
        this.hasUsedSmallRestThisRound = false;
    }

    /**
     * Prüft, ob die kleine Verschnaufpause bereits in dieser Runde genutzt wurde.
     * 
     * @return true wenn bereits genutzt, sonst false
     */
    public boolean hasUsedSmallRestThisRound() {
        return hasUsedSmallRestThisRound;
    }
}
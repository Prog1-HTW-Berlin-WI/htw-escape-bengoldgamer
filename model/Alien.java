package model;

/**
 * Abstrakte Basisklasse für alle Alientypen.
 * Repräsentiert die gemeinsamen Eigenschaften der Aliens.
 * 
 * @author bengoldgamer
 * @author tomski912
 */
public abstract class Alien {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 1729389822767173584L;

    private String name;
    private int lifePoints;
    private boolean friendly;
    private String greeting;

    /**
     * Erstellt ein neues Alien mit den Eigenschaften.
     * 
     * @param name Der Name des Aliens
     * @param lifePoints Die Lebenspunkte des Aliens
     * @param friendly true wenn das Alien freundlich ist, sonst false
     * @param greeting Der Begrüßungstext des Aliens
     */
    public Alien(String name, int lifePoints, boolean friendly, String greeting) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.friendly = friendly;
        this.greeting = greeting;
    }

    /**
     * Reduziert die Lebenspunkte des Aliens um den Schadenswert.
     * Fällt der Wert unter 0, werden die Lebenspunkte auf 0 gesetzt.
     * Gibt auf der Konsole den erlittenen Schaden aus.
     * 
     * @param amount Der Schadenswert
     */
    public void takeDamage(int amount) {
        this.lifePoints -= amount;
    
        if (this.lifePoints < 0) {
            this.lifePoints = 0;
        }
    
        System.out.println(this.name + " takes " + amount + " damage!");
        System.out.println("Remaining lifepoints " + this.lifePoints);
    }
    
    /**
     * Prüft, ob das Alien besiegt wurde.
     * 
     * @return true wenn die Lebenspunkte 0 oder weniger betragen, sonst false
     */
    public boolean isDefeated(){
        return this.lifePoints <= 0;
    }

    /**
     * Gibt den Namen des Aliens zurück.
     * 
     * @return Der Name des Aliens
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die aktuellen Lebenspunkte des Aliens zurück.
     * 
     * @return Die Lebenspunkte
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Gibt an, ob das Alien freundlich ist
     * 
     * @return true wenn freundlich, false wenn feindlich
     */
    public boolean isFriendly() {
        return friendly;
    }

    /**
     * Gibt den Begrüßungstext des Aliens zurück.
     * 
     * @return Der Begrüßungstext
     */
    public String getGreeting() {
        return greeting;
    }
    
    /**
     * Abstrakte Methode für den Angriff des Aliens.
     * Muss von jeder Unterklasse implementiert werden.
     * 
     * @return Der Schadenswert des Angriffs
     */
    public abstract int attack();
    
}
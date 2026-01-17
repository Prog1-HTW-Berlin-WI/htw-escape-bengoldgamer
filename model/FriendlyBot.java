package model;

/**
 * Repräsentiert einen freundlichen Roboter, ein friedliches Alien.
 * sucht nur nach dem Weg zur Bibliothek.
 * 
 * @author bengoldgamer
 * @author tomski912
 */

public class FriendlyBot extends Alien {

    private static final long serialVersionUID = 8472916283746192837L;

    private static final int STARTING_LIFE_POINTS = 15;

    /**
     * Erstellt einen neuen freundlichen Roboter.
     * Der Bot greift nicht an.
     */
    public FriendlyBot() {
        super("FriendlyBot-C3PO", STARTING_LIFE_POINTS, true, "A small robot rolls towards you.\n" + "Sorry, do you know where the library is?");
    }

    /**
     * Der freundliche Roboter greift nicht an.
     * Methode soll nie aufgerufen werden gibt aber 0 Schaden zurück.
     * 
     * @return 0
     */
    @Override
    public int attack() {
        System.out.println(getName() + "dodges and won't fight back!");
        return 0;
    }
    
}

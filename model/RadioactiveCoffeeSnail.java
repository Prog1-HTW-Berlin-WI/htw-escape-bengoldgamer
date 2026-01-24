package model;

/**
 * Repräsentiert eine radioaktive Kaffeeschnecke, ein feindliches Alien.
 * Diese Schnecke ist in einen Becher Kaffee gefallen und hat durch ein missglücktes
 * Experiment im Labor 1 mutagene Eigenschaften entwockelt und greift aggressiv an.
 * 
 * @author bengoldgamer
 * @author tomski912
 */
public class RadioactiveCoffeeSnail extends Alien {

    private static final long serialVersionUID = 1729389822767173584L;

    private static final int BASE_DAMAGE = 3;
    private static final int STARTING_LIFE_POINTS = 10;

    /**
     * Erstellt eine neue radioaktive Kaffeeschnecke.
     * Die Schnecke ist feindlich.
     */
    public RadioactiveCoffeeSnail() {
        super("Radioactive Coffeesnail", STARTING_LIFE_POINTS, false, "The snail glows green and\n" +
        "leaves a brown slime trail with a coffee smell");
    }

    /**
     * Die radioaktive Kaffeeschnecke greift mit ihrer Schleimspur an.
     * 
     * @return Der Schadenswert des Angriffs
     */
    @Override
    public int attack() {
        System.out.println(getName() + " spits macus!");
        return BASE_DAMAGE;
    }
    
}

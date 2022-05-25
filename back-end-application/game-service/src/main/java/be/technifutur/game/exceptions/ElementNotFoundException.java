package be.technifutur.game.exceptions;

public class ElementNotFoundException extends RuntimeException{

    private final Object id;
    private final Class<?> clazz; //class = mot-clé réservé

    public ElementNotFoundException(Object id, Class<?> clazz) {
        super("L'élément correspondant à l'id " + id + " n'a pas pu être trouvé");
        this.id = id;
        this.clazz = clazz;
    }

    public Object getId() { return id; }
    public Class<?> getClazz() { return clazz; }
}

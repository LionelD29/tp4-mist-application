package be.technifutur.exception;

public class MarketPriceNotFoundException extends RuntimeException {

    private final Object ref;
    private final Class<?> clas;

    public MarketPriceNotFoundException(Object ref, Class<?> clas) {
        super("Market price of ref ["+ref+"] not found. Output class expected : "+clas);
        this.ref = ref;
        this.clas = clas;
    }
}

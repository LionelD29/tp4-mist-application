package be.technifutur.market.exception;

import lombok.Getter;

@Getter
public class MarketPriceNotFoundException extends RuntimeException {

    private final Object ref;
    private final Class<?> clas;

    public MarketPriceNotFoundException(Object ref, Class<?> clas) {
        super("Market price of ref ["+ref+"] not found. Output class expected : "+clas.getSimpleName());
        this.ref = ref;
        this.clas = clas;
    }
}

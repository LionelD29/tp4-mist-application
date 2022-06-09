package be.technifutur.order.exception;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends RuntimeException{

    private final Object ref;
    private final Class<?> clazz;

    public OrderNotFoundException(Object ref, Class<?> clazz) {
        super("Order with ref ["+ref+"] not found.\nOutput class expected: " + clazz);
        this.ref = ref;
        this.clazz = clazz;
    }

}

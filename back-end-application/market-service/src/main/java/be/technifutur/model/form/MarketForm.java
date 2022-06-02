package be.technifutur.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MarketForm {
    private UUID gameRef;
    @Positive
    private double price;
    @PositiveOrZero
    private int stock;

}

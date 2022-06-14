package be.technifutur.shared.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarketForm {

    private UUID gameRef;
    @PositiveOrZero
    private double price;
    @PositiveOrZero
    private int stock;
    @PositiveOrZero
    private int promotion;
    @PositiveOrZero
    private int download;

}

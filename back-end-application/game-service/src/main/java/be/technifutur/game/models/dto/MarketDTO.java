package be.technifutur.game.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarketDTO {

    private UUID gameRef;
    private double price;
    private int stock;
    private int promotion;
}

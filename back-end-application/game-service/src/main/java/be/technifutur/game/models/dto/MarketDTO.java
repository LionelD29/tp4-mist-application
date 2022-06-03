package be.technifutur.game.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class MarketDTO {

    private UUID gameRef;
    private double price;
    private int stock;
    private int promotion;
}

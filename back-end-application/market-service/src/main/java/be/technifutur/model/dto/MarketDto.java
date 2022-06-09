package be.technifutur.model.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class MarketDto {

    private UUID gameRef;
    private double price;
    private int stock;
    private int promotion;
}

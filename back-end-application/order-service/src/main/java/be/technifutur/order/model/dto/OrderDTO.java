package be.technifutur.order.model.dto;

import be.technifutur.order.model.entity.OrderStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDTO {

    private UUID userRef;
//    private String buyerName;
    private String billingAddress;
    private int totalPrice;
    private LocalDate orderDate;
    private OrderStatus status;
    private List<GameDTO> games;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter @Setter
    @Builder
    public static class GameDTO {
        private UUID gameReference;
        private int howMany;
    }

}

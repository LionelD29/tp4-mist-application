package be.technifutur.order.model.dto;

import be.technifutur.order.model.entity.Game;
import be.technifutur.order.model.entity.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDTO {

    private Long id;
    private UUID user_ref;
    private String buyer_name;
    private String shipping_address;
    private int totalPrice;
    private LocalDate orderDate;
    private OrderStatus status;
    private List<Game> gamesToOrder;

}

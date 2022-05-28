package be.technifutur.order.business.mapper;

import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.Order;
import be.technifutur.order.model.form.OrderForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderMapper {

    private final GameMapper gameMapper;

    public Order formToEntity(OrderForm form) {
        if (form == null) {
            return null;
        }

        return Order.builder()
//                .buyerName(form.getBuyerName())
                .billingAddress(form.getBillingAddress())
                .games(form.getGames()
                        .stream()
                        .map(gameMapper::formToEntity)
                        .toList())
                .build();
    }

    public OrderDTO entityToDTO(Order entity) {
        if (entity == null) {
            return null;
        }

        return OrderDTO.builder()
                .userRef(entity.getUserRef())
//                .buyerName(entity.getBuyerName())
                .billingAddress(entity.getBillingAddress())
                .totalPrice(entity.getTotalPrice())
                .orderDate(entity.getOrderDate())
                .status(entity.getStatus())
                .games(entity.getGames()
                        .stream()
                        .map(gameMapper::entityToDTO)
                        .toList())
                .build();
    }

}

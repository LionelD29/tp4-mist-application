package be.technifutur.order.business.mapper;

import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.Order;
import be.technifutur.order.model.entity.OrderStatus;
import be.technifutur.order.model.form.OrderForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderMapper {

    private final GameMapper gameMapper;

    public Order formToEntity(OrderForm form, UUID userRef) {
        if (form == null) {
            return null;
        }

        return Order.builder()
//                .buyerName(form.getBuyerName())
                .userRef(userRef)
                .billingAddress(form.getBillingAddress())
                .orderDate(LocalDate.now())
                .status(OrderStatus.PAID)
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
//                .buyerName(entity.getBuyerName())
                .userRef(entity.getUserRef())
                .billingAddress(entity.getBillingAddress())
                .totalPrice(entity.getTotalPrice())
                .orderDate(entity.getOrderDate())
                .status(OrderStatus.SENT)
                .games(entity.getGames()
                        .stream()
                        .map(gameMapper::entityToDTO)
                        .toList())
                .build();
    }

}

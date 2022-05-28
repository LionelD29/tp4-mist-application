package be.technifutur.order.business.mapper;

import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.OnlineOrder;
import be.technifutur.order.model.form.OrderForm;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public OnlineOrder formToEntity(OrderForm form) {
        if (form == null) {
            return null;
        }

        return OnlineOrder.builder()
                .buyerName(form.getBuyer_name())
                .shippingAddress(form.getShipping_address())
                .gamesToOrder(form.getGamesToOrder())
                .build();
    }

    public OrderDTO entityToDTO(OnlineOrder entity) {
        if (entity == null) {
            return null;
        }

        return OrderDTO.builder()
                .id(entity.getId())
                .userRef(entity.getUserRef())
                .buyerName(entity.getBuyerName())
                .shippingAddress(entity.getShippingAddress())
                .totalPrice(entity.getTotalPrice())
                .orderDate(entity.getOrderDate())
                .status(entity.getStatus())
                .gamesToOrder(entity.getGamesToOrder())
                .build();
    }

}

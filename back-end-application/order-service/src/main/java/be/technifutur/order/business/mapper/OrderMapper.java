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
                .buyer_name(form.getBuyer_name())
                .shipping_address(form.getShipping_address())
                .gamesToOrder(form.getGamesToOrder())
                .build();
    }

    public OrderDTO entityToDTO(OnlineOrder entity) {
        if (entity == null) {
            return null;
        }

        return OrderDTO.builder()
                .id(entity.getId())
                .user_ref(entity.getUser_ref())
                .buyer_name(entity.getBuyer_name())
                .shipping_address(entity.getShipping_address())
                .totalPrice(entity.getTotalPrice())
                .orderDate(entity.getOrderDate())
                .status(entity.getStatus())
                .gamesToOrder(entity.getGamesToOrder())
                .build();
    }

}

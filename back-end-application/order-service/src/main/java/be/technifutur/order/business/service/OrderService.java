package be.technifutur.order.business.service;

import be.technifutur.order.business.mapper.OrderMapper;
import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.Order;
import be.technifutur.order.model.form.OrderForm;
import be.technifutur.order.repository.GameRepository;
import be.technifutur.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final GameRepository gameRepository;
    private final OrderMapper mapper;

    // CREATE NEW ORDER
    public OrderDTO placeOrder(UUID userRef, OrderForm form) {
        Order entity = mapper.formToEntity(form);
        orderRepository.findByUserRef(userRef).add(entity);
        return mapper.entityToDTO(entity);
    }

    // READ ORDERS LIST OF A SPECIFIC USER
    public List<OrderDTO> getOrdersByUser(UUID userRef) {
        return orderRepository.findByUserRef(userRef)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    // READ ONE ORDER OF A SPECIFIC USER
    public OrderDTO getOneUserOrderByOrderId(UUID userRef, Long orderId) {
        Order orderToGet = orderRepository.findByUserRefAndId(userRef, orderId);
        return mapper.entityToDTO(orderToGet);
    }

    // UPDATE ONE ORDER OF A SPECIFIC USER
//    public OrderDTO updateUserOrderByOrderId(UUID userRef, UUID gameRef, Long orderId, int quantity) {
//        Order orderToUpdate = orderRepository.findByUserRefAndId(userRef, orderId);
//    }

    // DELETE ONE USER ORDER BY ID
    public OrderDTO deleteUserOrderById(UUID userRef, Long orderId) {
        Order orderToDelete = orderRepository.deleteByUserRefAndId(userRef, orderId);
        return mapper.entityToDTO(orderToDelete);
    }

}

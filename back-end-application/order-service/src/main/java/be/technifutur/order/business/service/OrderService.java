package be.technifutur.order.business.service;

import be.technifutur.order.business.mapper.OrderMapper;
import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.Order;
import be.technifutur.order.model.form.OrderForm;
import be.technifutur.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    // CREATE NEW ORDER
    public OrderDTO placeOrder(UUID userRef, OrderForm form) {
        Order entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    // READ USER'S ORDERS LIST
    public List<OrderDTO> getOrdersByUser(UUID userRef) {
        return repository.findByUserRef(userRef)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }
}

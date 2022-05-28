package be.technifutur.order.business.service;

import be.technifutur.order.business.mapper.OrderMapper;
import be.technifutur.order.model.dto.OrderDTO;
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

    public List<OrderDTO> getOrdersByUser(UUID userRef) {
        return this.repository.findByUserRef(userRef)
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }
}

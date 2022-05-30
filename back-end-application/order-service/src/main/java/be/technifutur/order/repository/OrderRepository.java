package be.technifutur.order.repository;

import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserRef(UUID userRef);
    Order findByUserRefAndId(UUID userRef, Long id);
    Order deleteByUserRefAndId(UUID userRef, Long id);

}

package be.technifutur.order.repository;

import be.technifutur.order.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserRef(UUID userRef);
    Order findByUserRefAndId(UUID userRef, Long id);
    Order deleteByUserRefAndId(UUID userRef, Long id);

}

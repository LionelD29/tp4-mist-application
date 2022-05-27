package be.technifutur.order.repository;

import be.technifutur.order.model.entity.OnlineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OnlineOrder, Long> {
}

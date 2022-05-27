package be.technifutur.order.repository;

import be.technifutur.order.model.entity.OnlineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OnlineOrder, Long> {

    Optional<List<OnlineOrder>> findByUserRef(UUID userRef);

}

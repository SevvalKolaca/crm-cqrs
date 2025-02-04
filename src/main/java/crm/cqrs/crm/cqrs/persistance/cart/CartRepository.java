package crm.cqrs.crm.cqrs.persistance.cart;


import crm.cqrs.crm.cqrs.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    Optional<Cart> findByUserId(UUID userId);
}

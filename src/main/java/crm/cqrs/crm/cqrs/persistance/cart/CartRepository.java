package crm.cqrs.crm.cqrs.persistance.cart;


import crm.cqrs.crm.cqrs.domain.entity.Cart;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, UUID> { }

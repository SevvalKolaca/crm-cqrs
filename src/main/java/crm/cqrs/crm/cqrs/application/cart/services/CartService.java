package crm.cqrs.crm.cqrs.application.cart.services;

import crm.cqrs.crm.cqrs.domain.entity.Cart;
import crm.cqrs.crm.cqrs.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartService {

    Cart CreateCart(User user);

    Optional<Cart> findById(UUID id);
    List<Cart> findAll();

    Optional<Cart> findByUserId(UUID userId);

    UUID deleteCartForAUser(UUID id);

    Cart save(Cart cart);
    UUID delete(UUID id);
}

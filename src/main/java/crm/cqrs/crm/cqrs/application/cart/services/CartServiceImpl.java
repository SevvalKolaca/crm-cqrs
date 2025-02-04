package crm.cqrs.crm.cqrs.application.cart.services;

import crm.cqrs.crm.cqrs.domain.entity.Cart;
import crm.cqrs.crm.cqrs.domain.entity.User;
import crm.cqrs.crm.cqrs.persistance.cart.CartRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart CreateCart(User user) {

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setIsActive(true);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Optional<Cart> findById(UUID id) {
        return cartRepository.findById(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findByUserId(UUID userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public UUID deleteCartForAUser(UUID id) {
        cartRepository.deleteById(id);
        return id;
    }



    @Override
    public Cart save(Cart cart) {
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public UUID delete(UUID id) {
        return null;
    }


}

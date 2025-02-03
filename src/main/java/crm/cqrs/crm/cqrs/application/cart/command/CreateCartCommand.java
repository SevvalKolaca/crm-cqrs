package crm.cqrs.crm.cqrs.application.cart.command;

import an.awesome.pipelinr.Command;
import crm.cqrs.crm.cqrs.application.cart.mapper.CartMapper;
import crm.cqrs.crm.cqrs.domain.entity.Cart;
import crm.cqrs.crm.cqrs.persistance.cart.CartRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartCommand implements Command<CreatedCartResponse> {

    private BigDecimal totalPrice;

    @Component
    @RequiredArgsConstructor
    public static class CreateCartCommandHandler
            implements Command.Handler<CreateCartCommand, CreatedCartResponse>
    {
        private final CartRepository cartRepository;

        public CreateCartCommandHandler(CartRepository cartRepository) {
            this.cartRepository = cartRepository;
        }

        @Override
        public CreatedCartResponse handle(CreateCartCommand createCartCommand) {
            CartMapper cartMapper = CartMapper.INSTANCE;
            Cart cart = cartMapper.createCartFromCreateCommand(createCartCommand);
            cartRepository.save(cart);

            return cartMapper.createCartResponseFromCart(cart);
        }
    }
}

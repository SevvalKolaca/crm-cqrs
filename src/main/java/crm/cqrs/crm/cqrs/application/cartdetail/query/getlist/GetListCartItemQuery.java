package crm.cqrs.crm.cqrs.application.cartdetail.query.getlist;

import an.awesome.pipelinr.Command;
import crm.cqrs.crm.cqrs.domain.entity.Cart;
import crm.cqrs.crm.cqrs.persistance.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

public class GetListCartItemQuery implements Command<List<GetListCartDetailDto>> {

    @Component
    @RequiredArgsConstructor
    public static class GetListCartQueryHandler
            implements Command.Handler<GetListCartItemQuery, List<GetListCartDetailDto>>
    {
        private final CartRepository cartRepository;

        @Override
        public List<GetListCartDetailDto> handle(GetListCartItemQuery getListCartQuery) {
            List<Cart> carts = cartRepository.findAll();

            return carts
                    .stream()
                    .map(cart -> new GetListCartDetailDto(cart.getId(), cart.getTotalPrice()))
                    .toList();
        }
    }
}

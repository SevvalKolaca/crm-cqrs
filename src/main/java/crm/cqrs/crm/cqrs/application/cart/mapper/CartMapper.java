package crm.cqrs.crm.cqrs.application.cart.mapper;

import crm.cqrs.crm.cqrs.application.cart.command.CreateCartCommand;
import crm.cqrs.crm.cqrs.application.cart.command.CreatedCartResponse;
import crm.cqrs.crm.cqrs.domain.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart createCartFromCreateCommand(CreateCartCommand createAuthorCommand);
    CreatedCartResponse createCartResponseFromCart(Cart cart);
}

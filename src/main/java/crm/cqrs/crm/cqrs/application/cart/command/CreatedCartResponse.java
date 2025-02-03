package crm.cqrs.crm.cqrs.application.cart.command;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreatedCartResponse {

    private UUID id;

  //  private User user;


    private BigDecimal totalPrice;

    private Boolean isActive;
}

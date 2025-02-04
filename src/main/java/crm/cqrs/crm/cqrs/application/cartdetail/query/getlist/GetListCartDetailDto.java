package crm.cqrs.crm.cqrs.application.cartdetail.query.getlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListCartDetailDto {

    private UUID cartId;
    private UUID productId;
    private Integer quantity;
    private BigDecimal unitPrice;

    public GetListCartDetailDto(UUID id, BigDecimal totalPrice) {

    }
}

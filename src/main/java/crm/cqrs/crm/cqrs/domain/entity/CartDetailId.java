package crm.cqrs.crm.cqrs.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailId implements Serializable {

    private Integer cartId;

    private Integer productId;

}

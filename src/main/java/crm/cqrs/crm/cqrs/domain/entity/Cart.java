package crm.cqrs.crm.cqrs.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;


import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne
    @NotNull(message = "User cannot be null!")
    @JoinColumn(name = "customer_no", nullable = false)
    private Customer customer;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}
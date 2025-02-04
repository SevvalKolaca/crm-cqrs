package crm.cqrs.crm.cqrs.persistance.customer;

import crm.cqrs.crm.cqrs.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}

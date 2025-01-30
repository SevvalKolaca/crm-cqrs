package crm.cqrs.crm.cqrs.persistance.category;

import crm.cqrs.crm.cqrs.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

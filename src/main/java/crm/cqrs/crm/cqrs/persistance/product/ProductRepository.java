package crm.cqrs.crm.cqrs.persistance.product;

import crm.cqrs.crm.cqrs.domain.entity.Category;
import crm.cqrs.crm.cqrs.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByCategory_Id(Integer categoryId);
}

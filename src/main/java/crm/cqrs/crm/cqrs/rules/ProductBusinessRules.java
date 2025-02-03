package crm.cqrs.crm.cqrs.rules;

import crm.cqrs.crm.cqrs.persistance.product.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ProductBusinessRules {

    private final ProductRepository productRepository;

    public ProductBusinessRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void hasProductsInCategory(Integer id){
        if(productRepository.existsByCategory_Id(id)){
            throw new RuntimeException("Category cannot be deleted as it has associated products!");
        }
    }
}

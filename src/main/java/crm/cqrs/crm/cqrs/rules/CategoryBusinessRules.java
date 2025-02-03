package crm.cqrs.crm.cqrs.rules;

import crm.cqrs.crm.cqrs.domain.entity.Category;
import crm.cqrs.crm.cqrs.persistance.category.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;

    public Category categoryMustExist(Integer id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category must exist!"));
        return category;
    }

    public void categoryHasSubcategories(Integer id){
        List<Category> subcategories = categoryRepository.findAllByParentId(id);
        if(!subcategories.isEmpty())
            throw new RuntimeException("Category cannot be deleted as it has subcategories!");
    }
}

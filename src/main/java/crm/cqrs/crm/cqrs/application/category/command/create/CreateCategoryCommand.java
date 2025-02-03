package crm.cqrs.crm.cqrs.application.category.command.create;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import crm.cqrs.crm.cqrs.domain.entity.Category;
import crm.cqrs.crm.cqrs.persistance.category.CategoryRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

public class CreateCategoryCommand implements Command<CreatedCategoryResponse>
{
    @NotBlank(message = "Category Name cannot be blank")
    @Size(max = 100, message = "Category name length should be less than 100 char.")
    private String name;

    private List<CreateCategoryCommand> subcategories;

    private Boolean isActive;

    @JsonProperty("parent_category_id")
    private Integer parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreateCategoryCommand> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<CreateCategoryCommand> subcategories) {
        this.subcategories = subcategories;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Component
    //@RequiredArgsConstructor
    public static class CreateCategoryCommandHandler implements Command.Handler<CreateCategoryCommand, CreatedCategoryResponse>{

        private final CategoryRepository categoryRepository;

        public CreateCategoryCommandHandler(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        @Override
        public CreatedCategoryResponse handle(CreateCategoryCommand createCategoryCommand){
            Category category = new Category();
            category.setName(createCategoryCommand.getName());
            category.setIsActive(true);

            if(createCategoryCommand.getParentId() != null){
                Category parent = categoryRepository
                        .findById(createCategoryCommand.getParentId())
                        .orElseThrow(() -> new RuntimeException("Parent category Not Found"));
                category.setParent(parent);
            }
            categoryRepository.save(category);

            CreatedCategoryResponse createdCategoryResponse = new CreatedCategoryResponse(category.getId(), category.getName(), category.getParent(), category.getIsActive());
            return createdCategoryResponse;
        }
    }
}

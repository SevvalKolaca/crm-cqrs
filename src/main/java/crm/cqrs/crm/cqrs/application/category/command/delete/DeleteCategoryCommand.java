package crm.cqrs.crm.cqrs.application.category.command.delete;

import an.awesome.pipelinr.Command;
import crm.cqrs.crm.cqrs.domain.entity.Category;
import crm.cqrs.crm.cqrs.persistance.category.CategoryRepository;
import crm.cqrs.crm.cqrs.rules.CategoryBusinessRules;
import crm.cqrs.crm.cqrs.rules.ProductBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class DeleteCategoryCommand implements Command<DeleteCategoryResponse> {
    private Integer id;

    public DeleteCategoryCommand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Component
    public static class DeleteCategoryCommandHandler implements Command.Handler<DeleteCategoryCommand, DeleteCategoryResponse>{

        private final CategoryRepository categoryRepository;

        public DeleteCategoryCommandHandler(CategoryRepository categoryRepository, CategoryBusinessRules categoryBusinessRules, ProductBusinessRules productBusinessRules) {
            this.categoryRepository = categoryRepository;
            this.categoryBusinessRules = categoryBusinessRules;
            this.productBusinessRules = productBusinessRules;
        }

        private final CategoryBusinessRules categoryBusinessRules;
        private final ProductBusinessRules productBusinessRules;

        @Override
        public DeleteCategoryResponse handle(DeleteCategoryCommand deleteCategoryCommand) {

            Category category = categoryBusinessRules.categoryMustExist(deleteCategoryCommand.getId());
            productBusinessRules.hasProductsInCategory(deleteCategoryCommand.getId());

            categoryBusinessRules.categoryHasSubcategories(deleteCategoryCommand.getId());

            category.setIsActive(false);
            categoryRepository.save(category);

            DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();
            return deleteCategoryResponse;
        }
    }
}

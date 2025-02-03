package crm.cqrs.crm.cqrs.application.category.query.GetList;

import an.awesome.pipelinr.Command;
import crm.cqrs.crm.cqrs.domain.entity.Category;
import crm.cqrs.crm.cqrs.persistance.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class GetListCategoryQuery implements Command<List<GetListCategoryItemDto>> {

    // ...

    @Component
    //@RequiredArgsConstructor
    public static class GetListCategoryQueryHandler
            implements Command.Handler<GetListCategoryQuery, List<GetListCategoryItemDto>>
    {
        private final CategoryRepository categoryRepository;

        public GetListCategoryQueryHandler(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        @Override public List<GetListCategoryItemDto> handle(GetListCategoryQuery getListCategoryQuery)
        {
            List<Category> categories = categoryRepository.findAll();

            List<GetListCategoryItemDto> categoryDtos = categories
                    .stream()
                    .map(this::convertToListCategoryItemDto)
                    .collect(Collectors.toList());

            return categoryDtos;
        }


        private GetListCategoryItemDto convertToListCategoryItemDto(Category category)
        {
            List<GetListCategoryItemDto> subcategories = categoryRepository.findAllByParentId(category.getId())
                    .stream()
                    .map(subcategory -> new GetListCategoryItemDto(subcategory.getId(), subcategory.getName(), null))
                    .collect(Collectors.toList());

            return new GetListCategoryItemDto(
                    category.getId(),
                    category.getName(),
                    subcategories  //alt kategorilerin listesi
            );
        }
    }
}

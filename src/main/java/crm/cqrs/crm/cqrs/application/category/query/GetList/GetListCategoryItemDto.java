package crm.cqrs.crm.cqrs.application.category.query.GetList;

import crm.cqrs.crm.cqrs.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class GetListCategoryItemDto {

    private Integer id;
    private String name;
    private List<GetListCategoryItemDto> subcategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GetListCategoryItemDto> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<GetListCategoryItemDto> subcategories) {
        this.subcategories = subcategories;
    }
}

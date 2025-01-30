package crm.cqrs.crm.cqrs.application.category.command.create;

import crm.cqrs.crm.cqrs.domain.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/* eklediğim kategori bilgileri şunlardır.... şeklinde bir dönüş almak için
 * yani CREATE işlemine ait DTO burada!
 * */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedCategoryResponse {
    @NotBlank(message = "Category Name cannot be blank")
    @Size(max = 100, message = "Category name length should be less than 100 char.")
    private String name;

    private Integer id;

    private List<CreatedCategoryResponse> subCategories;

    private Boolean isActive;

    @JsonProperty("parent_category_id")
    private Integer parentId;

    public CreatedCategoryResponse(Integer id, @NotNull(message = "Name cannot be null!") String name, Category parent, Boolean isActive) {
    }

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

    public List<CreatedCategoryResponse> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<CreatedCategoryResponse> subCategories) {
        this.subCategories = subCategories;
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
}

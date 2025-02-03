package crm.cqrs.crm.cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import crm.cqrs.crm.cqrs.application.category.command.create.CreateCategoryCommand;
import crm.cqrs.crm.cqrs.application.category.command.create.CreatedCategoryResponse;
import crm.cqrs.crm.cqrs.application.category.command.delete.DeleteCategoryCommand;
import crm.cqrs.crm.cqrs.application.category.command.delete.DeleteCategoryResponse;
import crm.cqrs.crm.cqrs.application.category.query.GetList.GetListCategoryItemDto;
import crm.cqrs.crm.cqrs.application.category.query.GetList.GetListCategoryQuery;
import crm.cqrs.crm.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController {

    public CategoryController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedCategoryResponse create(@RequestBody CreateCategoryCommand createCategoryCommand){
        return createCategoryCommand.execute(pipeline);
    }

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetListCategoryItemDto> getAllCategories(){
        GetListCategoryQuery query = new GetListCategoryQuery();
        return query.execute(pipeline);
    }

    @DeleteMapping("/delete/{id}") // TODO:Delete
    @ResponseStatus(code = HttpStatus.OK)
    public DeleteCategoryResponse delete(@RequestParam("id") DeleteCategoryCommand deleteCategoryCommand){
        return deleteCategoryCommand.execute(pipeline);
    }

}

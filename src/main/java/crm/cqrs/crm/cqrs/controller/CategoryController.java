package crm.cqrs.crm.cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import crm.cqrs.crm.cqrs.application.category.command.create.CreateCategoryCommand;
import crm.cqrs.crm.cqrs.application.category.command.create.CreatedCategoryResponse;
import crm.cqrs.crm.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CategoryController extends BaseController {

    public CategoryController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedCategoryResponse create(@RequestBody CreateCategoryCommand createCategoryCommand){
        return createCategoryCommand.execute(pipeline);
    }

}

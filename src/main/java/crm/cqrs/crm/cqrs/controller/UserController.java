package crm.cqrs.crm.cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import crm.cqrs.crm.cqrs.application.user.command.create.CreateUserCommand;
import crm.cqrs.crm.cqrs.application.user.command.create.CreatedUserResponse;
import crm.cqrs.crm.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    public UserController(Pipeline pipeline) {
        super(pipeline);
    }


    //TODO: external server error 500 hatası veriyor, bakılacak!!!
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public CreatedUserResponse create(@RequestBody CreateUserCommand createUserCommand){
        return createUserCommand.execute(pipeline);
    }
}

package crm.cqrs.crm.cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import crm.cqrs.crm.cqrs.application.customer.command.create.CreateCustomerCommand;
import crm.cqrs.crm.cqrs.application.customer.command.create.CreatedCustomerResponse;
import crm.cqrs.crm.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CustomerController extends BaseController {

    public CustomerController(Pipeline pipeline) {
        super(pipeline);
    }


    //TODO: external server error 500 hatası veriyor, bakılacak!!!
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public CreatedCustomerResponse create(@RequestBody CreateCustomerCommand createCustomerCommand){
        return createCustomerCommand.execute(pipeline);
    }
}

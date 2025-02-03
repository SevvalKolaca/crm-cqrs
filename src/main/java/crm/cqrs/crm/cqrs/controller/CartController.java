package crm.cqrs.crm.cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import crm.cqrs.crm.cqrs.application.cart.command.CreateCartCommand;
import crm.cqrs.crm.cqrs.application.cart.command.CreatedCartResponse;
import crm.cqrs.crm.cqrs.core.web.BaseController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController extends BaseController {
    public CartController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCartResponse createCartItem(@RequestBody CreateCartCommand command) {
        return command.execute(pipeline);
    }
}

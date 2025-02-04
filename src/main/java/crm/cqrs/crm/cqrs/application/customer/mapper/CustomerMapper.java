package crm.cqrs.crm.cqrs.application.customer.mapper;

import crm.cqrs.crm.cqrs.application.customer.command.create.CreateCustomerCommand;
import crm.cqrs.crm.cqrs.application.customer.command.create.CreatedCustomerResponse;
import crm.cqrs.crm.cqrs.domain.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    public abstract Customer mapFromCreateCustomerCommand(CreateCustomerCommand createCustomerCommand);
    public abstract CreatedCustomerResponse mapCreatedResponseFromCustomer(Customer customer);
}

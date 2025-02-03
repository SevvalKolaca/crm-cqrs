package crm.cqrs.crm.cqrs.application.user.mapper;


import crm.cqrs.crm.cqrs.application.user.command.create.CreateUserCommand;
import crm.cqrs.crm.cqrs.application.user.command.create.CreatedUserResponse;
import crm.cqrs.crm.cqrs.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract User mapFromCreateUserCommand(CreateUserCommand createUserCommand);
    public abstract CreatedUserResponse mapCreatedResponseFromUser(User user);
}

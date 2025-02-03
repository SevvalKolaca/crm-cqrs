package crm.cqrs.crm.cqrs.application.user.command.create;

import an.awesome.pipelinr.Command;
import crm.cqrs.crm.cqrs.application.user.mapper.UserMapper;
import crm.cqrs.crm.cqrs.application.user.validations.ValidatePassword;
import crm.cqrs.crm.cqrs.domain.entity.User;
import crm.cqrs.crm.cqrs.persistance.user.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

public class CreateUserCommand implements Command<CreatedUserResponse> {

    @NotBlank(message = "First name cannot be blank!")
    @Length(min=2, message = "First name must be longer than 2 characters.")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank!")
    @Length(min=2, message = "Last name must be longer than 2 characters.")
    private String lastName;

    @Email(message = "Please enter a valid email address!")
    @NotBlank(message = "Email cannot be blank!")
    private String email;

    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 8, max = 64, message = "Password must be at least 8 characters long!")
    @ValidatePassword
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Component
    public static class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, CreatedUserResponse>{
        private final UserRepository userRepository;
        private final UserMapper userMapper;

        public CreateUserCommandHandler(UserRepository userRepository, UserMapper userMapper) {
            this.userRepository = userRepository;
            this.userMapper = userMapper;
        }

        @Override
        public CreatedUserResponse handle(CreateUserCommand createUserCommand){
            User user = userMapper.mapFromCreateUserCommand(createUserCommand);
            user.setIsActive(true);
            userRepository.save(user);
            return userMapper.mapCreatedResponseFromUser(user);
        }
    }

}

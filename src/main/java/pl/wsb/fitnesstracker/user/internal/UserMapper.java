package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.BasicDto;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserAddDto;
import pl.wsb.fitnesstracker.user.api.UserDto;

/**
 * Mapper class for converting between User entity and DTOs.
 * Handles transformation of data between different layers of the application.
 */
@Component
class UserMapper {

    /**
     * Converts a User entity to UserDto.
     *
     * @param user the user entity to convert
     * @return UserDto containing user data
     */
    UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    /**
     * Converts a User entity to BasicDto with simplified information.
     *
     * @param user the user entity to convert
     * @return BasicDto containing basic user data (ID, first name, last name)
     */
    BasicDto toBasicDto(User user) {
        return new BasicDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName()

        );

    }

    /**
     * Converts UserAddDto to User entity for creation.
     *
     * @param userAddDto the DTO containing new user data
     * @return User entity ready to be persisted
     */
    User toEntity(UserAddDto userAddDto) {
        return new User(
                userAddDto.firstName(),
                userAddDto.lastName(),
                userAddDto.birthdate(),
                userAddDto.email()
        );
    }


}

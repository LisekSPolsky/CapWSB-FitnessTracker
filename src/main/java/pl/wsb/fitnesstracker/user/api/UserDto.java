package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;


import java.time.LocalDate;

/**
 * Data Transfer Object for User entity.
 * Contains complete user information for API responses.
 *
 * @param id the unique identifier of the user (can be null for new users)
 * @param firstName the first name of the user
 * @param lastName the last name of the user
 * @param birthdate the date of birth (formatted as yyyy-MM-dd)
 * @param email the email address of the user
 */
public record UserDto(@Nullable Long id, String firstName, String lastName,
                      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                      String email) {

}




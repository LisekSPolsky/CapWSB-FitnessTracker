package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * Data Transfer Object for creating new users.
 * Contains all required information to create a new user account.
 *
 * @param firstName the first name of the new user
 * @param lastName the last name of the new user
 * @param birthdate the date of birth (formatted as yyyy-MM-dd)
 * @param email the email address for the new user
 */
public record UserAddDto(
        String firstName,
        String lastName,
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
        String email) {
}

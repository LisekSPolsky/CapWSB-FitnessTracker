package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/**
 * Simplified Data Transfer Object for User entity.
 * Contains only basic user information (ID and name).
 *
 * @param id the unique identifier of the user (can be null)
 * @param firstName the first name of the user
 * @param lastName the last name of the user
 */
public record BasicDto(@Nullable Long id, String firstName, String lastName) {
}

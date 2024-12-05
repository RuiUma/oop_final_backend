package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.UserDTO;

/**
 * UserDao defines methods for managing user data in the database.
 * It provides an abstraction layer for user-related operations.
 */
public interface UserDao {

    /**
     * Retrieves a user from the database based on their email.
     *
     * @param email The email of the user to be retrieved.
     * @return A UserDTO object representing the user, or null if the user does not exist.
     */
    UserDTO getUserByEmail(String email);

    /**
     * Inserts a new user into the database.
     *
     * @param userDTO A UserDTO object containing the user's details.
     * @return true if the user was successfully inserted, false otherwise.
     */
    Boolean insertUser(UserDTO userDTO);

    /**
     * Updates the details of an existing user in the database.
     *
     * @param userDTO A UserDTO object containing the updated user's details.
     * @return true if the user details were successfully updated, false otherwise.
     */
    Boolean modifyUser(UserDTO userDTO);
}

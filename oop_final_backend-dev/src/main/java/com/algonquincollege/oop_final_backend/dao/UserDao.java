package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.UserDTO;

import java.util.List;

public interface UserDao {
    UserDTO getUserByEmail(String email);
    Boolean insertUser(UserDTO userDTO);
    Boolean modifyUser(UserDTO userDTO);
}

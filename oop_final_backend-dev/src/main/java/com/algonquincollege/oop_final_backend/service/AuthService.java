package com.algonquincollege.oop_final_backend.service;

import org.mindrot.jbcrypt.BCrypt;

//import org.mindrot.jbcrypt.BCrypt;

import com.algonquincollege.oop_final_backend.dto.UserDTO;

public interface AuthService {
    public static String bcryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static Boolean verifyPassword(String password, String bcryptPassword) {
        return BCrypt.checkpw(password, bcryptPassword);
    }

    Boolean register(UserDTO userDTO);




    String login(UserDTO userDTO);

}

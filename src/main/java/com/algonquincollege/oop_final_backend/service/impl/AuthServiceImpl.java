package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.service.AuthService;
import org.mindrot.jbcrypt.BCrypt;

public class AuthServiceImpl implements AuthService {

    public static String bcryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static Boolean verifyPassword(String password, String bcryptPassword) {
        return BCrypt.checkpw(password, bcryptPassword);
    }
}

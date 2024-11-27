package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.Utils.JwtTool;

import com.algonquincollege.oop_final_backend.dao.UserDao;
import com.algonquincollege.oop_final_backend.dao.impl.UserDaoImpl;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LogManager.getLogger(AuthServiceImpl.class);
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public Boolean addProfessional(UserDTO userDTO) {
        return true;
    }

    @Override
    public Boolean addInstitution(UserDTO userDTO) {
        return true;
    }

    @Override
    public String login(UserDTO userDTO) {
        logger.info(userDTO);

        UserDTO user = userDao.getUserByEmail(userDTO.getEmail());
        if (user == null) {
            return null;
        }
        Boolean match = AuthService.verifyPassword(userDTO.getPassword(), user.getPassword());
        if (match) {
            userDTO.setPassword(null);
            return JwtTool.sign(userDTO);
        }
        return null;
    }
}

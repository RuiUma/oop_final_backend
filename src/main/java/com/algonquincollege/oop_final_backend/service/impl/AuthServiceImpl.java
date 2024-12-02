package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.Exception.BusinessException;
import com.algonquincollege.oop_final_backend.Utils.JwtTool;

import com.algonquincollege.oop_final_backend.dao.UserDao;
import com.algonquincollege.oop_final_backend.dao.impl.UserDaoImpl;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LogManager.getLogger(AuthServiceImpl.class);
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public Boolean register(UserDTO userDTO) {
        if (isUserExist(userDTO.getEmail())) {
            throw new BusinessException("Email Already Exists");
        }
        userDTO.setPassword(AuthService.bcryptPassword(userDTO.getPassword()));
        return userDao.insertUser(userDTO);
    }


    @Override
    public Map login(UserDTO userDTO) {
        logger.info(userDTO);
        Map map = new HashMap();

        UserDTO user = userDao.getUserByEmail(userDTO.getEmail());
        if (user == null) {
            return null;
        }
        Boolean match = AuthService.verifyPassword(userDTO.getPassword(), user.getPassword());
        if (match) {
            userDTO.setPassword(null);
            map.put("jwt", JwtTool.sign(user));
            map.put("userName", user.getName());
            map.put("userType", user.getUserType());
            map.put("profileCreated", user.getProfileCreated());
            return map;
        }
        return null;
    }

    private Boolean isUserExist(String email) {
        UserDTO user = userDao.getUserByEmail(email);
        if (null != user && user.getEmail() != null) {
            return true;
        }
        return false;
    }

}

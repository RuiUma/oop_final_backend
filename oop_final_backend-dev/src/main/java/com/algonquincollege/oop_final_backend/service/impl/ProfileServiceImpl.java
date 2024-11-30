package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.UserDao;
import com.algonquincollege.oop_final_backend.dao.impl.UserDaoImpl;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public Boolean save(UserDTO userDTO) {

        return userDao.modifyUser(userDTO);
    }

}

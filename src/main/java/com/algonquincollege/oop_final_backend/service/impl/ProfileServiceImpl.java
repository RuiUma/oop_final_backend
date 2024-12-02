package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.UserDao;
import com.algonquincollege.oop_final_backend.dao.impl.UserDaoImpl;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.ProfileService;

import java.util.HashMap;
import java.util.Map;

public class ProfileServiceImpl implements ProfileService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public Boolean save(UserDTO userDTO) {

        return userDao.modifyUser(userDTO);
    }

    @Override
    public Map getProfile(String email) {
        Map map = new HashMap();
        UserDTO userDTO = userDao.getUserByEmail(email);

        map.put("areaOfExpertise",userDTO.getAreaOfExpertise());
        map.put("educationBackground",userDTO.getEducationBackground());
        map.put("currentPosition",userDTO.getCurrentPosition());

        if (userDTO.getUserID() == null) {
            map.put("institutionName", "No Institution Name");
        } else {
            UserDTO institutionUser = userDao.getUserById(userDTO.getInstitutionID());
            if (institutionUser == null) {
                map.put("institutionName", "No Institution Name");
            } else {
                map.put("institutionName", institutionUser.getName());
            }

        }

        return map;
    }
}

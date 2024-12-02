package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.dto.UserDTO;

import java.util.Map;

public interface ProfileService {
    Boolean save(UserDTO userDTO);
    Map getProfile(String email);

}

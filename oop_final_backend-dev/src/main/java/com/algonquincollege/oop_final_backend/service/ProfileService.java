package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.dto.UserDTO;

public interface ProfileService {
    Boolean save(UserDTO userDTO);

}

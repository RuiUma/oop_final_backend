package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.vo.ApplicationVo;

import java.util.List;

public interface ApplicationDao {
    Boolean createApplication(ApplicationDTO applicationDTO);

    Boolean modifyApplication(int applicationId, String status);

    List<ApplicationVo> getApplicationsByUserId(int userId);


}

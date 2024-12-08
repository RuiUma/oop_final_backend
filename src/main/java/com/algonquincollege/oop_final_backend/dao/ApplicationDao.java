package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.vo.ApplicationVo;

import java.util.List;
import java.util.Map;

public interface ApplicationDao {
    Boolean createApplication(ApplicationDTO applicationDTO);

    Boolean modifyApplication(int applicationId, String status);

    List<ApplicationVo> getApplicationsByUserId(int userId);

    Map getApplicationProfessional(int applicationId);
    Map getProfAndInstByAppId(int applicationId);

}

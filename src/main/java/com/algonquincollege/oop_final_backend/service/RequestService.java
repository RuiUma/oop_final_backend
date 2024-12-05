package com.algonquincollege.oop_final_backend.service;

import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.vo.ApplicationVo;

import java.util.List;

public interface RequestService {
    Boolean createRequest(ApplicationDTO applicationDTO);
    Boolean makeDecision(int applicationId, String status);
    List<ApplicationVo> getApplicationsByUserId(int userId);

}

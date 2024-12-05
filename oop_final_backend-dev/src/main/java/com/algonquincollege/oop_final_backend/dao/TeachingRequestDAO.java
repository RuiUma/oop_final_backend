package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.dto.TeachingRequestDTO;
import java.util.List;

public interface TeachingRequestDAO {
    boolean createTeachingRequest(TeachingRequestDTO request);

    boolean updateTeachingRequestStatus(int requestID, String status);

    List<TeachingRequestDTO> getTeachingRequestsByCourseID(int courseID);
}

package com.algonquincollege.oop_final_backend.dao;

import java.util.List;
import com.algonquincollege.oop_final_backend.dto.TeachingRequestDTO;

/**
 * TeachingRequestDAO defines methods for managing teaching requests in the database.
 * It provides an abstraction layer for creating, updating, and retrieving teaching requests.
 */
public interface TeachingRequestDAO {

    /**
     * Creates a new teaching request in the database.
     *
     * @param request The TeachingRequestDTO object containing details of the request.
     * @return true if the request was created successfully, false otherwise.
     */
    boolean createTeachingRequest(TeachingRequestDTO request);

    /**
     * Updates the status of an existing teaching request in the database.
     *
     * @param requestID The unique identifier of the teaching request to be updated.
     * @param status The new status of the teaching request (e.g., Pending, Accepted, Rejected).
     * @return true if the status was updated successfully, false otherwise.
     */
    boolean updateTeachingRequestStatus(int requestID, String status);

    /**
     * Retrieves a list of teaching requests associated with a specific course.
     *
     * @param courseID The unique identifier of the course.
     * @return A list of TeachingRequestDTO objects representing the teaching requests for the course.
     */
    List<TeachingRequestDTO> getTeachingRequestsByCourseID(int courseID);
}

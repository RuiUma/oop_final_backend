package com.algonquincollege.oop_final_backend.dao;

import java.util.List;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;

/**
 * CourseDAO is an interface that defines methods for accessing and managing courses in the database.
 * It provides an abstraction layer for database operations related to courses.
 */
public interface CourseDAO {

    /**
     * Creates a new course in the database.
     *
     * @param course The CourseDTO object containing details of the course to be created.
     * @return true if the course was created successfully, false otherwise.
     */
    boolean createCourse(CourseDTO course);

    /**
     * Updates the details of an existing course in the database.
     *
     * @param course The CourseDTO object containing the updated details of the course.
     * @return true if the course was updated successfully, false otherwise.
     */
    boolean updateCourse(CourseDTO course);

    /**
     * Retrieves the details of a course by its ID.
     *
     * @param courseID The unique identifier of the course to be retrieved.
     * @return A CourseDTO object containing the course details, or null if no course is found with the given ID.
     */
    CourseDTO getCourseById(int courseID);

    /**
     * Retrieves a list of all courses offered by a specific institution.
     *
     * @param institutionId The unique identifier of the institution whose courses are to be retrieved.
     * @return A list of CourseDTO objects containing details of the courses offered by the institution.
     */
    List<CourseDTO> getCoursesByInstitution(int institutionId);
}

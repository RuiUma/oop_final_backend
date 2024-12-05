package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.ProfileService;
import com.algonquincollege.oop_final_backend.service.impl.ProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    ProfileService profileService = new ProfileServiceImpl();
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map parsedBody = (Map) req.getAttribute("parsedBody");
        UserDTO userDTO = new UserDTO();

        // get logged in user info
        userDTO.setEmail(req.getAttribute("userEmail").toString());
        userDTO.setName(req.getAttribute("userName").toString());
        userDTO.setUserType(req.getAttribute("userType").toString());


        // get data from the request body
        userDTO.setEducationBackground(getOrNull(parsedBody, "educationBackground"));
        userDTO.setAreaOfExpertise(getOrNull(parsedBody, "areaOfExpertise"));
        userDTO.setAddress(getOrNull(parsedBody, "address"));
        userDTO.setCurrentPosition(getOrNull(parsedBody, "currentPosition"));


        String institutionStr = parsedBody.getOrDefault("institution", "").toString();
        try {
            Integer institutionID = institutionStr.isEmpty() ? null : Integer.parseInt(institutionStr);
            userDTO.setInstitutionID(institutionID);
        } catch (NumberFormatException e) {
            // Handle invalid number format (e.g., log an error or set a default value)
            userDTO.setInstitutionID(null); // or a default value like 0
        }

        Boolean res = profileService.save(userDTO);

        ResponseWrapper rw = (ResponseWrapper)resp;

        ResponseObject<String> responseObject;
        if(res) {
            responseObject = ResponseObject.success("Profile saved.");
        } else {
            responseObject = ResponseObject.failure("Profile didn't saved.");
        }
        rw.setResponseDTO(responseObject);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map map = profileService.getProfile(req.getAttribute("userEmail").toString());


        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(map));
    }

    private String getOrNull(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof String) {
            String stringValue = (String) value;
            return stringValue.isEmpty() ? null : stringValue;
        }
        return null;
    }

}

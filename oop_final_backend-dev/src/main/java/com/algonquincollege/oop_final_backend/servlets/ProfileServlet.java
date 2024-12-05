package com.algonquincollege.oop_final_backend.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.ProfileService;
import com.algonquincollege.oop_final_backend.service.impl.ProfileServiceImpl;

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
        userDTO.setEducationBackground(parsedBody.get("educationBackground").toString());
        userDTO.setAreaOfExpertise(parsedBody.get("areaOfExpertise").toString());
        userDTO.setAddress(parsedBody.get("address").toString());

        Boolean res = profileService.save(userDTO);

        ResponseWrapper rw = (ResponseWrapper)resp;

        ResponseDTO<String> responseDTO;
        if(res) {
            responseDTO = ResponseDTO.success("Profile saved.");
        } else {
            responseDTO = ResponseDTO.failure("Profile didn't saved.");
        }
        rw.setResponseDTO(responseDTO);
    }
}

package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.AuthService;
import com.algonquincollege.oop_final_backend.service.impl.AuthServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(RegisterServlet.class);

    private AuthService authService = new AuthServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(parsedBody.get("password").toString());
        userDTO.setEmail(parsedBody.get("email").toString());
        userDTO.setName(parsedBody.get("name").toString());
        userDTO.setUserType(parsedBody.get("userType").toString());

        Boolean res = authService.register(userDTO);
        ResponseWrapper rw = (ResponseWrapper)resp;

        ResponseDTO<String> responseDTO;
        if(res) {
            responseDTO = ResponseDTO.success("register success");
        } else {
            responseDTO = ResponseDTO.failure("register failed");
        }
        rw.setResponseDTO(responseDTO);
    }
}

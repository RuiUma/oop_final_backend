package com.algonquincollege.oop_final_backend.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseDTO;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.AuthService;
import com.algonquincollege.oop_final_backend.service.impl.AuthServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    private AuthService authService = new AuthServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(parsedBody.get("password").toString());
        userDTO.setEmail(parsedBody.get("email").toString());

        String jwt = authService.login(userDTO);

        Map map = new HashMap();
        ResponseWrapper rw = (ResponseWrapper)resp;

        if (jwt != null) {
            resp.setHeader("Set-Cookie", "jwt=" + jwt + "; Path=/; SameSite=Strict;");
            map.put("jwt", jwt);

            ResponseDTO<Map> responseDTO = ResponseDTO.success(map);
            rw.setResponseDTO(responseDTO);

        } else {
            resp.setHeader("testheader", "testvalue");
            ResponseDTO<Map> responseDTO = ResponseDTO.failure("login failed");
            rw.setResponseDTO(responseDTO);
        }



    }
}

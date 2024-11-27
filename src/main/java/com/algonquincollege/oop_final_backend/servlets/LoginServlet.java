package com.algonquincollege.oop_final_backend.servlets;

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

        logger.info(userDTO);
        String jwt = authService.login(userDTO);

        logger.info(jwt);

        if (jwt != null) {
            resp.setHeader("Set-Cookie", "jwt=" + jwt + "; Path=/; SameSite=Strict;");
            resp.getWriter().write(jwt);
        }



    }
}

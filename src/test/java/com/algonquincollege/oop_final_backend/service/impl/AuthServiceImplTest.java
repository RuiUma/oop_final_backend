package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthServiceImplTest {
    private AuthService authService;

    @BeforeEach
    void initService() {
        authService = new AuthServiceImpl();
    }

    @Test
    void loginTest() {
        UserDTO userPro = new UserDTO();
        userPro.setEmail("testProEmail");
        userPro.setPassword("123");

        UserDTO userInst = new UserDTO();
        userInst.setEmail("testInstitution");
        userInst.setPassword("123");

        assertNotNull(authService.login(userPro));
        assertNotNull(authService.login(userInst));
    }
}

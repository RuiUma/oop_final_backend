package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.service.ProfileService;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProfileServiceImplTest {
    private ProfileService profileService = new ProfileServiceImpl();

    @BeforeAll
    static void getConnection() throws Exception {
        ConnectionPool.getInstance();
    }


    @Test
    void testGetProfile(){
        Map pro = profileService.getProfile("testProEmail");
        Map institution = profileService.getProfile("testInstitution");

        assertNotNull(pro);
        assertNotNull(institution);

    }


}

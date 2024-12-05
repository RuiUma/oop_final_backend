package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.ApplicationDao;
import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.dao.NotificationDao;
import com.algonquincollege.oop_final_backend.dao.impl.ApplicationDaoImpl;
import com.algonquincollege.oop_final_backend.dao.impl.CourseDaoImpl;
import com.algonquincollege.oop_final_backend.dao.impl.NotificationDaoImpl;
import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;
import com.algonquincollege.oop_final_backend.factory.NotificationFactory;
import com.algonquincollege.oop_final_backend.service.RequestService;
import com.algonquincollege.oop_final_backend.vo.ApplicationVo;

import java.util.List;

public class RequestServiceImpl implements RequestService {
    ApplicationDao applicationDao = new ApplicationDaoImpl();
    CourseDao courseDao = new CourseDaoImpl();
    NotificationDao notificationDao = new NotificationDaoImpl();
    @Override
    public Boolean createRequest(ApplicationDTO applicationDTO) {
        Boolean dataCreated = applicationDao.createApplication(applicationDTO);
        int userId = courseDao.getInstitutionByCourseId(applicationDTO.getCourseID());
        String msg = applicationDTO.getProfessionalID() + "send an application on " + applicationDTO.getCourseID();

        NotificationDTO notificationDTO = NotificationFactory.createNotification(userId, msg);
        Boolean Notified = notificationDao.createNotification(notificationDTO);
        return dataCreated && Notified;
    }

    @Override
    public Boolean makeDecision(int applicationId, String status) {
        Boolean appStatus = applicationDao.modifyApplication(applicationId, status);

        return appStatus;
    }

    @Override
    public List<ApplicationVo> getApplicationsByUserId(int userId) {
        return applicationDao.getApplicationsByUserId(userId);
    }
}

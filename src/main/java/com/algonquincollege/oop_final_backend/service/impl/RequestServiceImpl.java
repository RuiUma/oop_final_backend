package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.Utils.GetUtil;
import com.algonquincollege.oop_final_backend.dao.ApplicationDao;
import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.dao.NotificationDao;
import com.algonquincollege.oop_final_backend.dao.UserDao;
import com.algonquincollege.oop_final_backend.dao.impl.ApplicationDaoImpl;
import com.algonquincollege.oop_final_backend.dao.impl.CourseDaoImpl;
import com.algonquincollege.oop_final_backend.dao.impl.NotificationDaoImpl;
import com.algonquincollege.oop_final_backend.dao.impl.UserDaoImpl;
import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.dto.NotificationDTO;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.factory.NotificationFactory;
import com.algonquincollege.oop_final_backend.service.RequestService;
import com.algonquincollege.oop_final_backend.vo.ApplicationVo;

import java.util.List;
import java.util.Map;

public class RequestServiceImpl implements RequestService {
    ApplicationDao applicationDao = new ApplicationDaoImpl();
    CourseDao courseDao = new CourseDaoImpl();
    NotificationDao notificationDao = new NotificationDaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public Boolean createRequest(ApplicationDTO applicationDTO) {
        Boolean dataCreated = applicationDao.createApplication(applicationDTO);
        int userId = courseDao.getInstitutionByCourseId(applicationDTO.getCourseID());
        String professionalName = userDao.getUserById(applicationDTO.getProfessionalID()).getName();
        String courseTitle = courseDao.getCourseTitleByCourseId(applicationDTO.getCourseID());
        String msg = professionalName + " send an application on " + courseTitle;
        NotificationDTO notificationDTO = NotificationFactory.createNotification(userId, msg);
        Boolean Notified = notificationDao.createNotification(notificationDTO);
        return dataCreated && Notified;
    }

    @Override
    public Boolean makeDecision(int applicationId, String status) {
        Boolean appStatus = applicationDao.modifyApplication(applicationId, status);
        Map map = applicationDao.getProfAndInstByAppId(applicationId);

        String msg = map.get("institutionName").toString() + " have " + status + " your application";
        int ProfUserId = GetUtil.getIntValue(map, "professionalId");
        NotificationDTO notificationDTO = NotificationFactory.createNotification(ProfUserId, msg);
        Boolean Notified = notificationDao.createNotification(notificationDTO);

        return appStatus && Notified;
    }

    @Override
    public List<ApplicationVo> getApplicationsByUserId(int userId) {
        return applicationDao.getApplicationsByUserId(userId);
    }
}

package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.ProfessionalDao;
import com.algonquincollege.oop_final_backend.dao.impl.ProfessionalDaoImpl;
import com.algonquincollege.oop_final_backend.service.ProfessionalService;
import com.algonquincollege.oop_final_backend.vo.CourseFilterVo;

import java.util.HashMap;
import java.util.Map;

public class ProfessionalServiceImpl implements ProfessionalService {
    ProfessionalDao professionalDao = new ProfessionalDaoImpl();
    @Override
    public Map getDashBoard(Map map) {

        Map resMap = new HashMap();
        CourseFilterVo vo = new CourseFilterVo();
        vo.setCourseCode(map.get("courseCode").toString());
        vo.setInstitution(map.get("institution").toString());
        vo.setTerm(map.get("term").toString());

        resMap.put("applications", professionalDao.getApplicationsByUserId(Integer.parseInt(map.get("userId").toString())));
        resMap.put("courses", professionalDao.searchCourseByFilters(vo));
        return resMap;
    }

    @Override
    public String getApplicationStatus(int courseId, int userId) {

        return "";
    }
}

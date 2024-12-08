package com.algonquincollege.oop_final_backend.service.impl;

import com.algonquincollege.oop_final_backend.dao.GeneralDao;
import com.algonquincollege.oop_final_backend.dao.impl.GeneralDaoImpl;
import com.algonquincollege.oop_final_backend.service.GeneralDataService;

import java.util.HashMap;
import java.util.Map;

public class GeneralDataServiceImpl implements GeneralDataService {
    GeneralDao generalDao = new GeneralDaoImpl();
    @Override
    public Map getGeneralData() {
        Map map = new HashMap();
        map.put("institutionOptions", generalDao.getInstitutionSelections());
        map.put("termOptions", generalDao.getTermSelections());
        return map;
    }
}

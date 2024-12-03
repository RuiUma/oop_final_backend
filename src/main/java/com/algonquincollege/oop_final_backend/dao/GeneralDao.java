package com.algonquincollege.oop_final_backend.dao;

import com.algonquincollege.oop_final_backend.vo.SelectOption;

import java.util.List;

public interface GeneralDao {
    List<SelectOption> getInstitutionSelections();
    List<SelectOption> getTermSelections();
}

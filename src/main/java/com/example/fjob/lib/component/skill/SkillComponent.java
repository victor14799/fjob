package com.example.fjob.lib.component.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.dataset.skill.UserSkill;

import java.util.List;

public interface SkillComponent {
    List<SkillDataset> getListSkill();
    List<UserSkill> getSkillOfUser(String username);
    int updateSkill(UserSkill userSkill,String newSkillId);
    int insertSkill(UserSkill userSkill);
}

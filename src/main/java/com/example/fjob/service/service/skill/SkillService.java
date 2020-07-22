package com.example.fjob.service.service.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.dataset.skill.UserSkill;

import java.util.List;

public interface SkillService {
    List<SkillDataset> getSkillCategory();
    List<UserSkill> getSkillOfUser(String username);
}

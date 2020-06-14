package com.example.fjob.service.service.skill;

import com.example.fjob.lib.component.skill.SkillComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImp implements SkillService {

    private SkillComponent component;

    @Autowired
    public SkillServiceImp(SkillComponent component) {
        this.component = component;
    }

    @Override
    public List<String> getSkillCategory() {
        return component.getListSkill();
    }
}

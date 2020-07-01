package com.example.fjob.lib.component.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.mapper.skill.SkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillComponentImp implements SkillComponent{
    private SkillMapper mapper;

    @Autowired
    public SkillComponentImp(SkillMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<SkillDataset> getListSkill() {
        return mapper.getListSkill();
    }
}

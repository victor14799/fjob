package com.example.fjob.service.service.skill;

import com.example.fjob.lib.component.skill.SkillComponent;
import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.dataset.skill.UserSkill;

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
    public List<SkillDataset> getSkillCategory() {
        return component.getListSkill();
    }

	@Override
	public List<UserSkill> getSkillOfUser(String username) {
		// TODO Auto-generated method stub
		return component.getSkillOfUser(username);
	}

    @Override
    public int updateSkill(UserSkill userSkill,String newSkillId) {
        return component.updateSkill(userSkill,newSkillId);
    }

    @Override
    public int insertSkill(UserSkill userSkill) {
        return component.insertSkill(userSkill);
    }
}

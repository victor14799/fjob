package com.example.fjob.lib.mapper.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillMapper {
    @Select("SELECT " +
            "SKILL_ID AS skillId, " +
            "NAME AS skillName " +
            "FROM " +
            "SKILL_CATEGORY " +
            "ORDER BY NAME")
    List<SkillDataset> getListSkill();
}

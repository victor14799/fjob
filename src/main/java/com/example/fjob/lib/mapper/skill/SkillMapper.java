package com.example.fjob.lib.mapper.skill;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillMapper {
    @Select("SELECT NAME " +
            "FROM " +
            "SKILL_CATEGORY " +
            "ORDER BY NAME")
    List<String> getListSkill();
}

package com.example.fjob.lib.mapper.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.dataset.skill.UserSkill;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    
    @Select("select " + 
    		"	T01.skill_id as skillId," + 
    		"	T01.name as skillName," + 
    		"	hs.experience as experience," + 
    		"	hs.user_name as username" + 
    		" from " + 
    		"	has_skill as hs " + 
    		"inner join skill_category as T01 using(skill_id)" + 
    		"" + 
    		"where user_name = #{username}")
    List<UserSkill> getSkillOfUser(@Param("username") String username);
}

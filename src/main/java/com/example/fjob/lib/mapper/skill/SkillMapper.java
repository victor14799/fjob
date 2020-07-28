package com.example.fjob.lib.mapper.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.dataset.skill.UserSkill;

import org.apache.ibatis.annotations.*;

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
    		"inner join skill_category as T01 using(skill_id) " + 
    		"where hs.user_name = #{username}")
    List<UserSkill> getSkillOfUser(@Param("username") String username);

    @Update("UPDATE has_skill " +
			"SET skill_id = #{newSkillId}," +
			"experience = #{userSkill.experience}," +
			"upd_date = clock_timestamp() " +
			"WHERE user_name = #{userSkill.username} " +
			"and skill_id = #{userSkill.skillId}")
	int updateSkill(@Param("userSkill") UserSkill userSkill,@Param("newSkillId") String newSkillId);

    @Insert("INSERT INTO has_skill(user_name,skill_id,experience,ins_date) " +
			"values(#{userSkill.username},#{userSkill.skillId},#{userSkill.experience},clock_timestamp())")
	int insertSkill(@Param("userSkill") UserSkill userSkill);

	@Delete("DELETE FROM has_skill " +
			"WHERE user_name = #{userSkill.username} AND skill_id = #{userSkill.skillId}")
	int deleteSkill(@Param("userSkill") UserSkill userSkill);
}

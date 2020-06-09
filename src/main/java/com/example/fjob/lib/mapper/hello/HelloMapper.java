package com.example.fjob.lib.mapper.hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HelloMapper {
	
	@Select("	SELECT COUNT(1) 	"
			+ "	FROM Account		")
	int count();
}

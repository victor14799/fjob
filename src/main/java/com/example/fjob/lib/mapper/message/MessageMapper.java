package com.example.fjob.lib.mapper.message;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.fjob.lib.dataset.message.Message;

@Mapper
public interface MessageMapper {

	@Select(" SELECT " + "	mess_id as id, " + "	username, " + "	title, " + "	body, " + "	payload, " + "	seen_flg, "
			+ "	ins_date, "
			+ "	add_username as addUsername, img " + " FROM message " + " WHERE username = #{username} Order by ins_date DESC")
	List<Message> getMessage(@Param("username") String username);

	@Update("UPDATE message " + "set seen_flg=#{seen_flg} " + "WHERE mess_id= #{id}" + "AND username = #{username}")
	boolean updSeenFlgMessage(@Param("seen_flg") String seen_flg,@Param("username") String username,@Param("id") String id);

	@Delete("DELETE FROM message WHERE mess_id=#{id}")
	boolean delMessage(@Param("id") String id);

	@Delete("DELETE FROM message WHERE username = #{username}")
	boolean clearMessage(@Param("username") String username);
	
	@Insert("INSERT INTO "
			+ "message (mess_id, username, title, body, payload, seen_flg, add_username, img, ins_date) "
			+ "VALUES(#{id}, "
			+ "	#{username}, "
			+ "	#{title},"
			+ " #{body},"
			+ " #{payload},"
			+ " #{seen_flg},"
			+ "	#{addUsername}, "
			+ "	#{img},	"
			+ " CURRENT_TIMESTAMP)" )
	boolean insertMessage(Message message);
	
	@Select("Select COALESCE(img,'') from account where user_name = #{username}")
	String getImg(@Param("username") String username);
}

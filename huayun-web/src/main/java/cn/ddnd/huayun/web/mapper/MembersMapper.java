package cn.ddnd.huayun.web.mapper;

import cn.ddnd.huayun.web.pojo.Members;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface MembersMapper {

    @Insert("INSERT INTO members(`username`, `password`) " +
            "VALUES(#{username}, #{password})")
    boolean insertMember(Members members);

    @Select("SELECT * FROM members WHERE `username` = #{username}")
    Members findMemberByUsername(Members members);

    @Update("UPDATE members SET password = #{password}, email = #{email}, phone = #{phone}" +
            ", key_id = #{keyId}, key_secret = #{keySecret} WHERE username = #{username}")
    boolean updateMember(Members members);
}

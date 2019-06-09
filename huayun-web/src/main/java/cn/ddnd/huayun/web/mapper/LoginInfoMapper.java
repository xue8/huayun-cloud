package cn.ddnd.huayun.web.mapper;

import cn.ddnd.huayun.web.pojo.LoginInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface LoginInfoMapper {

    @Insert("INSERT INTO login_info(`datetime`, `username`, `isp`, `city`) " +
            "VALUES(#{datetime}, #{username}, #{isp}, #{city})")
    boolean insertLoginInfo(LoginInfo info);

    @Select("SELECT * FROM login_info WHERE `username` = #{username} order by id desc limit 10")
    List<LoginInfo> findLoginInfoByUsername(LoginInfo info);

}

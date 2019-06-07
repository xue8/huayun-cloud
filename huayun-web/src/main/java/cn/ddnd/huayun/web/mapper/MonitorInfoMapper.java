package cn.ddnd.huayun.web.mapper;

import cn.ddnd.huayun.web.pojo.MonitorInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MonitorInfoMapper {

    @Insert("INSERT INTO monitor_info(`index`, `time`, `cycle`, `type`, `threshold`, `id`, `username`, " +
            "`phone`, `email`) " +
            "VALUES(#{index}, #{time}, #{cycle}, #{type}, #{threshold}, #{id}, #{username}, " +
            "#{phone}, #{email})")
    boolean insertMonitorInfo(MonitorInfo info);

    @Select("SELECT * FROM monitor_info WHERE `id` = #{id}")
    List<MonitorInfo> findMonitorInfoById(String id);

    @Select("SELECT * FROM monitor_info WHERE `monitor_info_id` = #{monitor_info_id}")
    List<MonitorInfo> findMonitorInfoByMonitorId(String monitor_info_id);

    @Select("SELECT * FROM monitor_info WHERE `username` = #{username}")
    List<MonitorInfo> findMonitorInfoByUsername(String username);

    @Select("SELECT * FROM monitor_info WHERE `id` = #{id} AND `time` = #{time}")
    List<MonitorInfo> findMonitorInfoByIdAndTime(String id, Integer time);

    @Select("SELECT * FROM monitor_info WHERE `time` = #{time}")
    List<MonitorInfo> findMonitorInfoByTime(Integer time);

    @Delete("DELETE FROM monitor_info WHERE `monitor_info_id` = #{id}")
    boolean deleteMonitorInfo(String id);

}
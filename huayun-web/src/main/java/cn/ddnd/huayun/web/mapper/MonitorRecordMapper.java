package cn.ddnd.huayun.web.mapper;

import cn.ddnd.huayun.web.pojo.MonitorRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MonitorRecordMapper {

    @Insert("INSERT INTO monitor_record(`id`, `datetime`, `index`, `threshold`, `username`) " +
            "VALUES(#{id}, #{datetime}, #{index}, #{threshold}, #{username})")
    boolean insertMonitorRecord(MonitorRecord record);

    @Select("SELECT * FROM monitor_record WHERE `username` = #{username}")
    List<MonitorRecord> findMonitorRecordByUsername(String username);

}

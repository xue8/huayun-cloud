package cn.ddnd.huayun.es.mapper;

import cn.ddnd.huayun.es.pojo.Cloud;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CloudMapper {

    @Insert("INSERT INTO cloud_cpu(datetime, unit, used, username, cloud_id, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{interval})")
    void insertCloudCpu(Cloud cloud);

    @Insert("INSERT INTO cloud_ram(datetime, unit, used, username, cloud_id, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{interval})")
    void insertCloudRam(Cloud cloud);

    @Insert("INSERT INTO cloud_io_read(datetime, unit, used, username, cloud_id, tag, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudIoRead(Cloud cloud);

    @Insert("INSERT INTO cloud_io_write(datetime, unit, used, username, cloud_id, tag, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudIoWrite(Cloud cloud);

    @Insert("INSERT INTO cloud_iops_read(datetime, unit, used, username, cloud_id, tag, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudIopsRead(Cloud cloud);

    @Insert("INSERT INTO cloud_iops_write(datetime, unit, used, username, cloud_id, tag, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudIopsWrite(Cloud cloud);

    @Insert("INSERT INTO cloud_disk_used(datetime, unit, used, username, cloud_id, tag, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudDiskUsed(Cloud cloud);


    @Insert("INSERT INTO cloud_fip_in(datetime, unit, used, username, cloud_id, ip, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudFipIn(Cloud cloud);

    @Insert("INSERT INTO cloud_fip_out(datetime, unit, used, username, cloud_id, ip, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{tag}, #{interval})")
    void insertCloudFipOut(Cloud cloud);

}

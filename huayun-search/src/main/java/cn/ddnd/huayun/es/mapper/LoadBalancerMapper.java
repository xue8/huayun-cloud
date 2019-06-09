package cn.ddnd.huayun.es.mapper;

import cn.ddnd.huayun.es.pojo.Cloud;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoadBalancerMapper {
    @Insert("INSERT INTO lb_in(datetime, unit, used, username, lb_id, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{interval})")
    void insertLoadBalancerIn(Cloud cloud);

    @Insert("INSERT INTO lb_out(datetime, unit, used, username, lb_id, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{interval})")
    void insertBalancerOut(Cloud cloud);

}

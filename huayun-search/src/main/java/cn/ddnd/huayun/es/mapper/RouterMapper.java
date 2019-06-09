package cn.ddnd.huayun.es.mapper;

import cn.ddnd.huayun.es.pojo.Cloud;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RouterMapper {
    @Insert("INSERT INTO router_in(datetime, unit, used, username, router_id, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{interval})")
    void insertRouterIn(Cloud cloud);

    @Insert("INSERT INTO router_out(datetime, unit, used, username, router_id, `interval`) " +
            "VALUES(#{datetime}, #{unit}, #{used}, #{username}, #{cloudId}, #{interval})")
    void insertRouterOut(Cloud cloud);
}

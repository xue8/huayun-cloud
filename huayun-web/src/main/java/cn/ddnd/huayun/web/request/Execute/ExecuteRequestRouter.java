package cn.ddnd.huayun.web.request.Execute;

import cn.ddnd.huayun.web.pojo.Router;
import com.alibaba.fastjson.JSON;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class ExecuteRequestRouter extends ExecuteRequest{

    /**
     * 路由器相关操作
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.put("Action", "DescribeInstances");
        map.putAll(parameter);
        return doExecute();
    }

}

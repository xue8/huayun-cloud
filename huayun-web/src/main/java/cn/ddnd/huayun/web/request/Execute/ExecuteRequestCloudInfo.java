package cn.ddnd.huayun.web.request.Execute;

import cn.ddnd.huayun.web.pojo.CloudResponse;
import com.alibaba.fastjson.JSON;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class ExecuteRequestCloudInfo extends ExecuteRequest {

    /**
     * 获取账户云服务器信息请求的执行
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

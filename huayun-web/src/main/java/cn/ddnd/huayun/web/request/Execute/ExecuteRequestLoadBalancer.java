package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestLoadBalancer extends ExecuteRequest{

    /**
     * 负载均衡相关操作
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);
        return doExecute();
    }

}

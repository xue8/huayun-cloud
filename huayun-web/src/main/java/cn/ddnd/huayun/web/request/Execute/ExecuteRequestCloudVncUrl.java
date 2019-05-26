package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudVncUrl extends ExecuteRequest {

    /**
     * 查询实例的管理终端地址。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);

        return doExecute();
    }
}

package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudStop extends ExecuteRequest {

    /**
     * 云服务器重启请求的执行
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);

        return doExecute();
    }
}

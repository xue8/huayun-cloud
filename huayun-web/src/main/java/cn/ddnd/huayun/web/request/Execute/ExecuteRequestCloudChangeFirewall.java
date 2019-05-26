package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudChangeFirewall extends ExecuteRequest {

    /**
     * 修改云主机防火墙
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);

        return doExecute();
    }
}

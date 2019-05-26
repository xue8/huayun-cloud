package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudDeleteSnapshot extends ExecuteRequest {

    /**
     * 删除云主机快照，同时会删除对应的系统盘快照信息。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);

        return doExecute();
    }
}

package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudQuerySnapshots extends ExecuteRequest {

    /**
     * 查询云主机快照信息，可根据查询条件查询多条记录。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);
        return doExecute();
    }
}

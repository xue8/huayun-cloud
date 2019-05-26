package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudCreateSnapshot extends ExecuteRequest {

    /**
     * 创建云主机快照，仅仅创建系统盘快照。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);

        return doExecute();
    }
}

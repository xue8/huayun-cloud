package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudApplySnapshot extends ExecuteRequest {

    /**
     * 云主机快照还原，仅仅还原对应的云主机系统盘，
     * 数据盘不会还原，如果需要还原数据盘需要单独还原云硬盘快照。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);

        return doExecute();
    }
}

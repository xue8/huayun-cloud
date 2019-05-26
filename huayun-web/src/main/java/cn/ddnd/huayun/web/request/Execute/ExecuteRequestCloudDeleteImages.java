package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudDeleteImages extends ExecuteRequest {

    /**
     * 删除镜像，根据镜像标识删除镜像，同时也会删除对应的模板、盘、快照信息，前提是该镜像下没有云主机了。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);
        return doExecute();
    }
}

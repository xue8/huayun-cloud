package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudQueryImages extends ExecuteRequest {

    /**
     * 查询镜像信息，查询一条或者多条可用镜像信息，可根据标识、操作系统标识、用途、名称等条件查询。
     * 默认查询出公有镜像，如果查询出自定义镜像，Shared需要传false。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);
        return doExecute();
    }
}

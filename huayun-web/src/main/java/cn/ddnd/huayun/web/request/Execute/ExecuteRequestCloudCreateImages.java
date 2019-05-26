package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestCloudCreateImages extends ExecuteRequest {

    /**
     * 创建自定义镜像，从指定的实例制作一个自定义镜像，
     * 使用这种方式创建的镜像总是非共享的，该镜像只有创建者可以使用。实例必须是关机状态。
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);
        return doExecute();
    }
}

package cn.ddnd.huayun.log.request.Execute;

import cn.ddnd.huayun.log.message.CloudDiskMessageHandleImpl;
import cn.ddnd.huayun.log.message.MessageHandle;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * @program: huayun
 * @description: Iops读日志
 * @author: Xue 8
 * @create: 2019-05-23 17:33
 **/
public class ExecuteRequestIopsWrite extends ExecuteRequest{
    @Override
    public void execute() {
        map.put("Action", "InstanceIopsWriteMonitor");
        map.put("Id", "i-zz6rj39kty724");
        map.put("StartTime", startDateTime);
        map.put("EndTime", endDateTime);

        Request request = okHttpRequest.getRequestUrl(map);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                MessageHandle handle = new CloudDiskMessageHandleImpl();
                Map map = handle.handle(response.body().string(), "iops_write");
                rabbitmqService.publish(map);
            }
        });
    }
}

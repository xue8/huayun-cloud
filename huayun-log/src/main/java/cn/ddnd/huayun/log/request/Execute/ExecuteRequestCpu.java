package cn.ddnd.huayun.log.request.Execute;

import cn.ddnd.huayun.log.message.MessageHandle;
import cn.ddnd.huayun.log.message.CloudMessageHandleImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * @program: huayun
 * @description: CPU日志收集
 * @author: Xue 8
 * @create: 2019-05-23 16:14
 **/
public class ExecuteRequestCpu extends ExecuteRequest {

    @Override
    public void execute() {

        map.put("Action", "InstanceCpuMonitor");
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
                MessageHandle handle = new CloudMessageHandleImpl();
                Map map = handle.handle(response.body().string(), "cpu");;
                rabbitmqService.publish(map);
            }
        });
    }
}

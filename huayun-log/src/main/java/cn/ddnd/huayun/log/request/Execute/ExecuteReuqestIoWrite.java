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
 * @description: 磁盘IO写日志
 * @author: Xue 8
 * @create: 2019-05-23 17:30
 **/
public class ExecuteReuqestIoWrite extends ExecuteRequest{
    @Override
    public void execute() {
        map.put("Action", "InstanceIoWriteMonitor");
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
                Map map = handle.handle(response.body().string(), "io_write");
                rabbitmqService.publish(map);
            }
        });
    }
}

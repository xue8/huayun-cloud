package cn.ddnd.huayun.log.request.Execute;

import cn.ddnd.huayun.log.config.Global;
import cn.ddnd.huayun.log.message.CloudDiskMessageHandleImpl;
import cn.ddnd.huayun.log.message.LoadBalancerHandleImpl;
import cn.ddnd.huayun.log.message.MessageHandle;
import cn.ddnd.huayun.log.message.RouterHandleImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: huayun
 * @description: 均衡器流入速率
 * @author: Xue 8
 * @create: 2019-05-23 17:30
 **/
public class ExecuteReuqestloadBalancerIn extends ExecuteRequest{
    @Override
    public void execute() {
//        map.put("Action", "LbVipBytesInMnt");
//        map.put("Region", "cn-chengdu");
//        map.put("Id", "lb-nj7yj57ai75f");
//        map.put("StartTime", startDateTime);
//        map.put("EndTime", endDateTime);

        if (Global.lbIdList == null || Global.lbIdList.size() == 0)
            return;
        for (String str : Global.lbIdList) {
            map.put("Action", "LbVipBytesInMnt");
            map.put("Region", "cn-chengdu");
            map.put("Id", str);
            map.put("StartTime", startDateTime);
            map.put("EndTime", endDateTime);
            Map map1 = new HashMap(map);

            Request request = okHttpRequest.getRequestUrl(map1);
            try {
                Response response = okHttpClient.newCall(request).execute();
                MessageHandle handle = new LoadBalancerHandleImpl();
                Map map = handle.handle(response.body().string(), "lb_in", String.valueOf(map1.get("Id")));
                if (map == null || map.size() == 0)
                    return;
                rabbitmqService.publish(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

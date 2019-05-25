package cn.ddnd.huayun.web.request.Execute;

import cn.ddnd.huayun.web.pojo.CloudResponse;
import com.alibaba.fastjson.JSON;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class ExecuteRequestCloudInfo extends ExecuteRequest {

    @Override
    public Object execute(Map parameter) {
        map.put("Action", "DescribeInstances");
        map.put("Id", "i-zz6rj39kty724");
        map.putAll(parameter);

        Request request = okHttpRequest.getRequestUrl(map);
        try {
            Response response = okHttpClient.newCall(request).execute();
            CloudResponse cloudResponse = JSON.parseObject(response.body().string(), CloudResponse.class);
            return cloudResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

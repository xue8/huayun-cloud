package cn.ddnd.huayun.web.request.Execute;

import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ExecuteRequestCheckIdentity extends ExecuteRequest{

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 身份验证请求的执行
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.put("AccessKey", parameter.get("AccessKey"));
        map.put("Action", "DescribeInstances");
        map.put("Region", "cn-suzhou1");

        map.putAll(parameter);
        return doExecute();
    }

    @Override
    public Object doExecute() {
        Request request = okHttpRequest.getRequestUrl(map);
        try {
            Response response = okHttpClient.newCall(request).execute();
            String str = response.body().string();
            if (str.contains("ErrorCode")) {  // 身份验证失败
                return "Authentication failure";
            } else {    // 身份验证成功
                return "Authentication successful";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

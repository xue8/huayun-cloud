package cn.ddnd.huayun.log.request;

import java.util.Map;

public interface OkHttpRequest {
    okhttp3.Request getRequestUrl(Map<String, String> parameters);
}

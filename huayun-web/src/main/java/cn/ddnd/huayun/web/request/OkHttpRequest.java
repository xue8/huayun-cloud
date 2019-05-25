package cn.ddnd.huayun.web.request;

import java.util.Map;

public interface OkHttpRequest {
    okhttp3.Request getRequestUrl(Map<String, String> parameters);
}

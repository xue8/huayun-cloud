package cn.ddnd.huayun.web.request;

import java.util.Map;

public interface OkHttpRequest {
    okhttp3.Request getRequestUrl(Map<String, String> parameters);
    okhttp3.Request putMonitorRequest(String monitorName, String n);
    okhttp3.Request deleteMonitorRequest(Map<String, String> parameters);
}

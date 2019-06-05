package cn.ddnd.huayun.web.request;

import cn.ddnd.huayun.web.config.Global;
import okhttp3.Request;

import java.util.Map;


public class OkHttpRequestImpl implements OkHttpRequest {

    /**
     * 传入请求参数，调用 getSignature 方法构造出最终的请求 url
     * @param parameters 请求参数
     * @return 返回 OkHttp 的 Request 对象
     */
    @Override
    public okhttp3.Request getRequestUrl(Map<String, String> parameters) {
        Signature signature = new Signature();
        String accessKey = parameters.get("AccessKey");
        String url = Global.requestApiUrl;
        String requestUrl = signature.getSignature(parameters, accessKey);
        requestUrl = url + "?" + requestUrl;
        okhttp3.Request request = new okhttp3.Request.Builder()
                .get()
                .addHeader("Date", parameters.get("Date"))
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .url(requestUrl)
                .build();
        return request;
    }

    @Override
    public Request putMonitorRequest(String monitorName, String n) {
        return null;
    }

    @Override
    public Request deleteMonitorRequest(Map<String, String> parameters) {
        return null;
    }
}

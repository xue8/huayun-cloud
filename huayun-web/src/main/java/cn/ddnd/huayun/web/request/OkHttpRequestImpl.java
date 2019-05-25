package cn.ddnd.huayun.web.request;

import cn.ddnd.huayun.web.config.Global;

import java.util.Map;


public class OkHttpRequestImpl implements OkHttpRequest {

    @Override
    public okhttp3.Request getRequestUrl(Map<String, String> parameters) {
        Signature signature = new Signature();
        String accessKey = parameters.get("AccessKey");
        String url = Global.requesApiUrl;
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
}

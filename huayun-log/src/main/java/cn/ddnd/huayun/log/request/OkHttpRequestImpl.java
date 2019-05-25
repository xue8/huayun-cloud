package cn.ddnd.huayun.log.request;

import cn.ddnd.huayun.log.config.Global;

import java.util.Map;

/**
 * @program: huayun
 * @description: 构造 OkHTTP request
 * @author: Xue 8
 * @create: 2019-05-21 22:16
 **/

public class OkHttpRequestImpl implements OkHttpRequest {

    @Override
    public okhttp3.Request getRequestUrl(Map<String, String> parameters) {
        Signature signature = new Signature();
        String accessKey = Global.accessKeySecret;
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

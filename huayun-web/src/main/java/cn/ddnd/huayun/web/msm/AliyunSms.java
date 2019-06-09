package cn.ddnd.huayun.web.msm;

import cn.ddnd.huayun.web.config.Global;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AliyunSms {

    @Autowired
    OkHttpClient okHttpClient;

    /**
      * 短信发送
     */
    public boolean send(String mobile, String content) {
        String appCode = Global.appCode;
        return excute(mobile, appCode, content);
    }

    private boolean excute(String mobile, String appCode, String content) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, "");
        String url = "http://dxyzm.market.alicloudapi.com/chuangxin/dxjk?content=" + content  + "&mobile=" + mobile;
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header("Authorization", "APPCODE " + appCode)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String var = response.body().string();
            System.out.println("----------------");
            System.out.println(mobile + "   " +  content);
            System.out.println(url);
            System.out.println("rep:" + var);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

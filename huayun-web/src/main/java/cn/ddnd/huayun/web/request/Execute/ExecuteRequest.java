package cn.ddnd.huayun.web.request.Execute;

import cn.ddnd.huayun.web.ioc.ApplicationUtil;
import cn.ddnd.huayun.web.config.Global;
import cn.ddnd.huayun.web.pojo.CloudResponse;
import cn.ddnd.huayun.web.request.OkHttpRequest;
import cn.ddnd.huayun.web.request.OkHttpRequestImpl;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class ExecuteRequest {

    OkHttpClient okHttpClient;

    OkHttpRequest okHttpRequest;
    String date;
    String startDateTime;
    String endDateTime;
    Map map;
    String accessKeyId;

    public ExecuteRequest() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss +0800");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        this.okHttpRequest = new OkHttpRequestImpl();
        this.date = format.format(nowDate);
        this.startDateTime = format1.format(nowDate.getTime() - 60000);
        this.endDateTime = format1.format(nowDate);
        this.accessKeyId = Global.accessKeyId;
        this.map = new HashMap();
        map.put("Action", "InstanceCpuMonitor");
        map.put("Region", "cn-huaian");
        map.put("Date", date);
        map.put("AccessKeyId", accessKeyId);
        map.put("Version", "1.0");
        this.okHttpClient = (OkHttpClient) ApplicationUtil.getBean(OkHttpClient.class);
    }

    public abstract Object execute(Map parameter);

    public Object doExecute() {
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

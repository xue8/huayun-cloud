package cn.ddnd.huayun.log.request.Execute;

import cn.ddnd.huayun.log.config.Global;
import cn.ddnd.huayun.log.ioc.ApplicationUtil;
import cn.ddnd.huayun.log.request.OkHttpRequest;
import cn.ddnd.huayun.log.request.OkHttpRequestImpl;
import cn.ddnd.huayun.log.service.RabbitmqService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: huayun
 * @description: 执行日志请求
 * @author: Xue 8
 * @create: 2019-05-23 16:04
 **/

public abstract class ExecuteRequest {

    OkHttpClient okHttpClient;
    RabbitmqService rabbitmqService;

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
        this.rabbitmqService = (RabbitmqService) ApplicationUtil.getBean(RabbitmqService.class);
    }

    public abstract void execute();
}

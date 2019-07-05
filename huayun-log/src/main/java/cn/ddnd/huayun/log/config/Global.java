package cn.ddnd.huayun.log.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Global {

    public static String exchange = "huayun.fanout";
    public static String routingkey;
    public static String requesApiUrl = "https://api.chinac.com/";
    public static String accessKeyId = "36c34ff3094b4dec9786dcc35d1f0d41";
    public static String accessKeySecret = "b87e24ad3b00420fadec14a9260ca94e";
    public static Integer cloudCpu;
    public static Integer cloudMemory;
    public static Integer cloudDiskUsed;
    public static Integer cloudIoRead;
    public static Integer cloudIoWrite;
    public static Integer cloudIopsRead;
    public static Integer cloudIopsWrite;
    public static Integer cloudFipIn;
    public static Integer cloudFipOut;
    public static List<String> cloudIdList;
    public static List<String> routerIdList;
    public static List<String> lbIdList;

    static {
        cloudIdList = new ArrayList<>();
        cloudIdList.add("i-zz6rj39kty724;cn-huaian");
        cloudIdList.add("i-sf7yj5f9m734n;cn-chengdu");

        routerIdList = new ArrayList<>();
        routerIdList.add("r-xy7yj5d03e570;cn-chengdu");
        routerIdList.add("r-eu7yj5d082833;cn-chengdu");
        routerIdList.add("r-8v7yj5d0d110y;cn-chengdu");
        routerIdList.add("r-ea5nj5dd9y67n;cn-anxi");

        lbIdList = new ArrayList<>();
        lbIdList.add("lb-hf7yj5d02194c;cn-chengdu");

    }
//    @Value("${global.rabbitmq.exchange}")
//    private void setExchange(String exchange) {
//        this.exchange = exchange;
//    }

//    @Value("${global.rabbitmq.routing-key}")
//    private void setRoutingkey(String routingkey) {
//        this.routingkey = routingkey;
//    }
//
//    @Value("${global.huayun.access-key-id}")
//    private void setAccessKeyId(String accessKeyId) {
//        Global.accessKeyId = accessKeyId;
//    }
//
//    @Value("${global.huayun.access-key-secret}")
//    private void setAccessKeySecret(String accessKeySecret) {
//        Global.accessKeySecret = accessKeySecret;
//    }
//
//    @Value("${global.cloud.cpu}")
//    private void setCloudCpu(Integer cloudCpu) {
//        Global.cloudCpu = cloudCpu;
//    }
//
//    @Value("${global.cloud.memory}")
//    private void setCloudMemory(Integer cloudMemory) {
//        Global.cloudMemory = cloudMemory;
//    }
//
//    @Value("${global.cloud.disk-used}")
//    private void setCloudDiskUsed(Integer cloudDiskUsed) {
//        Global.cloudDiskUsed = cloudDiskUsed;
//    }
//
//    @Value("${global.cloud.io-read}")
//    private void setCloudIoRead(Integer cloudIoRead) {
//        Global.cloudIoRead = cloudIoRead;
//    }
//
//    @Value("${global.cloud.io-write}")
//    private void setCloudIoWrite(Integer cloudIoWrite) {
//        Global.cloudIoWrite = cloudIoWrite;
//    }
//
//    @Value("${global.cloud.iops-read}")
//    private void setCloudIopsRead(Integer cloudIopsRead) {
//        Global.cloudIopsRead = cloudIopsRead;
//    }
//
//    @Value("${global.cloud.iops-write}")
//    private void setCloudIopsWrite(Integer cloudIopsWrite) {
//        Global.cloudIopsWrite = cloudIopsWrite;
//    }
//
//    @Value("${global.cloud.fip-in}")
//    private void setCloudFipIn(Integer cloudFipIn) {
//        Global.cloudFipIn = cloudFipIn;
//    }
//
//    @Value("${global.cloud.fip-out}")
//    private void setCloudFipOut(Integer cloudFipOut) {
//        Global.cloudFipOut = cloudFipOut;
//    }
//
//    @Value("${global.huayun.request-api-url}")
//    private void setRequesApiUrl(String url) {
//        Global.requesApiUrl = url;
//    }
//
//    @Value("${global.huayun.cloud-id}")
//    private void setCloudIdList(List cloudIdList) {
//        Global.cloudIdList = cloudIdList;
//    }
//
//    @Value("${global.huayun.router-id}")
//    private void setRouterIdList(List routerIdList) {
//        Global.routerIdList = routerIdList;
//    }
//
//    @Value("${global.huayun.lb-id}")
//    private void setIbIdList(List lbIdList) {
//        Global.lbIdList = lbIdList;
//    }
}

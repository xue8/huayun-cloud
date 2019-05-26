//package cn.ddnd.huayun.web;
//
//import cn.ddnd.huayun.web.pojo.CloudResponse;
//import com.alibaba.fastjson.JSON;
//import com.dianping.cat.Cat;
//import com.dianping.cat.message.Event;
//import com.dianping.cat.message.Transaction;
//
//public class Test {
//    public static void main(String[] args) {
//        Transaction t = Cat.newTransaction("URL", "192.168.43.210");
//
//        try {
//            Cat.logEvent("URL.Server", "192.168.43.210", Event.SUCCESS, "ip=192.168.43.210");
//            Cat.logMetricForCount("metric.key");
//            Cat.logMetricForDuration("metric.key", 5);
//
//            t.setStatus(Transaction.SUCCESS);
//        } catch (Exception e) {
//            t.setStatus(e);
//            Cat.logError(e);
//        } finally {
//            t.complete();
//        }
//    }
//}

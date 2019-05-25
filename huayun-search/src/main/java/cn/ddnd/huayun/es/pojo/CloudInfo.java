package cn.ddnd.huayun.es.pojo;

import java.io.Serializable;

/**
 * @program: huayun
 * @description:
 * @author: Xue 8
 * @create: 2019-05-23 20:36
 **/

public class CloudInfo implements Serializable {
    String datetime;
    String unit;
    Double used;
    String username;
    String id;
    String tag;
    String ip;
    Integer interval;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUsed() {
        return used;
    }

    public void setUsed(Double used) {
        this.used = used;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "CloudInfo{" +
                "datetime='" + datetime + '\'' +
                ", unit='" + unit + '\'' +
                ", used=" + used +
                ", username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                ", ip='" + ip + '\'' +
                ", interval=" + interval +
                '}';
    }
}

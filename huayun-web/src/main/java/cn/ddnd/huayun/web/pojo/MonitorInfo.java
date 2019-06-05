package cn.ddnd.huayun.web.pojo;

import java.io.Serializable;

public class MonitorInfo implements Serializable {

    public final static String TYPE_ONLYONCE = "TYPE_ONLYONCE";
    public final static String TYPE_ALWAYS = "TYPE_ALWAYS";
    public final static String TYPE_AVERAGE= "TYPE_AVERAGE";

    private String index;
    private Integer time;
    private Integer cycle;
    private Integer type;
    private Double threshold;
    private Double total;
    private String id;
    private String username;
    private String monitorInfoId;
    private String email;
    private Long phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMonitorInfoId() {
        return monitorInfoId;
    }

    public void setMonitorInfoId(String monitorInfoId) {
        this.monitorInfoId = monitorInfoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MonitorInfo{" +
                "index='" + index + '\'' +
                ", minute=" + time +
                ", cycle=" + cycle +
                ", type='" + type + '\'' +
                ", threshold=" + threshold +
                ", total=" + total +
                '}';
    }
}

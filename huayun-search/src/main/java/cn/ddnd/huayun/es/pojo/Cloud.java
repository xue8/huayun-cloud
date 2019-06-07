package cn.ddnd.huayun.es.pojo;

public class Cloud {
    String datetime;
    String unit;
    Double used;
    String username;
    String cloudId;
    String tag;
    Integer interval;

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
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

    public String getCloudId() {
        return cloudId;
    }

    public void setCloudId(String cloudId) {
        this.cloudId = cloudId;
    }

    @Override
    public String toString() {
        return "Cloud{" +
                "datetime='" + datetime + '\'' +
                ", unit='" + unit + '\'' +
                ", used=" + used +
                ", username='" + username + '\'' +
                ", cloudId='" + cloudId + '\'' +
                ", tag='" + tag + '\'' +
                ", interval=" + interval +
                '}';
    }
}

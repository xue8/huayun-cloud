package cn.ddnd.huayun.web.pojo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MonitorRequest {
    private String index;
    private Integer time;
    private Integer cycle;
    private String type;
    private Double threshold;
    private Double total;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getMinute() {
        return time;
    }

    public void setMinute(Integer minute) {
        this.time = minute;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "MonitorRequest{" +
                "index='" + index + '\'' +
                ", minute=" + time +
                ", cycle=" + cycle +
                ", type='" + type + '\'' +
                ", threshold=" + threshold +
                ", total=" + total +
                '}';
    }
}

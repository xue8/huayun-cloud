package cn.ddnd.huayun.log.pojo;

/**
 * @program: huayun
 * @description:
 * @author: Xue 8
 * @create: 2019-05-23 11:27
 **/

public class Cloud {
    String taskId;
    String unit;
    int interval;
    Object data;

    @Override
    public String toString() {
        return "Cloud{" +
                "taskId='" + taskId + '\'' +
                ", unit='" + unit + '\'' +
                ", interval=" + interval +
                ", data=" + data +
                '}';
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}

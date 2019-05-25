package cn.ddnd.huayun.web.pojo;

public class CloudResponse {
    String taskId;
    String action;
    Integer totalCount;
    Object instanceSet;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Object getInstanceSet() {
        return instanceSet;
    }

    public void setInstanceSet(Object instanceSet) {
        this.instanceSet = instanceSet;
    }
}

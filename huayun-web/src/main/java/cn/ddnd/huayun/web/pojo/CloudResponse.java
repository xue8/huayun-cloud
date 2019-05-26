package cn.ddnd.huayun.web.pojo;

public class CloudResponse {
    String taskId;
    String action;
    Integer totalCount;
    Object instanceSet;
    Object instanceSnapshotId;
    Object instanceSnapshotSet;
    Object firewallId;
    Object instanceVncUrl;
    Object imageSet;
    Object imageId;

    public Object getImageSet() {
        return imageSet;
    }

    public void setImageSet(Object imageSet) {
        this.imageSet = imageSet;
    }

    public Object getImageId() {
        return imageId;
    }

    public void setImageId(Object imageId) {
        this.imageId = imageId;
    }

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

    public Object getInstanceSnapshotId() {
        return instanceSnapshotId;
    }

    public void setInstanceSnapshotId(Object instanceSnapshotId) {
        this.instanceSnapshotId = instanceSnapshotId;
    }

    public Object getInstanceSnapshotSet() {
        return instanceSnapshotSet;
    }

    public void setInstanceSnapshotSet(Object instanceSnapshotSet) {
        this.instanceSnapshotSet = instanceSnapshotSet;
    }

    public Object getFirewallId() {
        return firewallId;
    }

    public void setFirewallId(Object firewallId) {
        this.firewallId = firewallId;
    }

    public Object getInstanceVncUrl() {
        return instanceVncUrl;
    }

    public void setInstanceVncUrl(Object instanceVncUrl) {
        this.instanceVncUrl = instanceVncUrl;
    }
}

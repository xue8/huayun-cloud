package cn.ddnd.huayun.web.pojo;

public class Cloud {
    String id;
    String name;
    String publicIp;
    String privateIp;
    String seriesName;
    Integer cpu;
    Integer memory;
    Integer bandWidth;
    String osName;
    String status;
    String productStatus;
    String dueTime;

    @Override
    public String toString() {
        return "Cloud{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", publicIp='" + publicIp + '\'' +
                ", privateIp='" + privateIp + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", bandWidth=" + bandWidth +
                ", osName='" + osName + '\'' +
                ", status='" + status + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", dueTime='" + dueTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }
}

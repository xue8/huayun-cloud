package cn.ddnd.huayun.web.pojo;

public class CloudRequest {
    String index;
    String type;
    String username;
    String id;
    String startDatetime;
    String endDatetime;
    Double start;
    Double end;
    boolean sort;

    @Override
    public String toString() {
        return "CloudRequest{" +
                "index='" + index + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", startDatetime='" + startDatetime + '\'' +
                ", endDatetime='" + endDatetime + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", sort=" + sort +
                '}';
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public boolean isSort() {
        return sort;
    }

    public void setSort(boolean sort) {
        this.sort = sort;
    }
}

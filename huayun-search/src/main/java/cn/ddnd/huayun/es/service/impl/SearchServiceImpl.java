package cn.ddnd.huayun.es.service.impl;

import cn.ddnd.huayun.es.service.SearchService;
import com.alibaba.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Service
public class SearchServiceImpl {
    String index;
    String type;
    String startDatetime;
    String endDatetime;
    String id;
    String username;
    boolean sort;
    Double start;
    Double end;

    public SearchServiceImpl(SearchServiceImpl.Builder builder){
        this.index = builder.index;
        this.type = builder.type;
        this.startDatetime = builder.startDatetime;
        this.endDatetime = builder.endDatetime;
        this.id = builder.id;
        this.username = builder.username;
        this.start = builder.start;
        this.end = builder.end;
        this.sort = builder.sort;
    }

    public Object getSearchResult() {
        if (startDatetime == null || startDatetime.equals("")) {
            startDatetime = "0";
        }
        if ( endDatetime == null || endDatetime.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String date = format.format(new Date());
            endDatetime = date;
        }
        if (start == null || start.equals("")) {
            start = 0D;
        }
        if (end == null || end.equals("")) {
            end = 100D;
        }
        if (((startDatetime != null && !startDatetime.equals("null")) || (endDatetime != null && !endDatetime.equals("null")))  // 日期和使用率两个范围的查询
                && (start != null || end != null))
            return new ElasticsearchSearchServiceImpl(this).searchByDatetimeAndUsedRange();
        else if ((startDatetime != null && !startDatetime.equals("null")) || (endDatetime != null && !endDatetime.equals("null")))  // 日期范围的查询
            return new ElasticsearchSearchServiceImpl(this).searchByDatetimeRange();
        else if (start != null || end != null)   // 使用率范围的查询
            return new ElasticsearchSearchServiceImpl(this).searchByUsedRange();
        else // 无参，使用默认方法，最大可返回100条数据
            return new ElasticsearchSearchServiceImpl(this).searchByDefault();
    }

    public String getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isSort() {
        return sort;
    }

    public Double getStart() {
        return start;
    }

    public Double getEnd() {
        return end;
    }

    static public class Builder{
        String index;
        String type;
        String startDatetime;
        String endDatetime;
        String id;
        String username;
        boolean sort = false;
        Double start;
        Double end;

        public Builder setIndex(String index) {
            this.index = index;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setStartDatetime(String startDatetime) {
            this.startDatetime = startDatetime;
            return this;
        }

        public Builder setEndDatetime(String endDatetime) {
            this.endDatetime = endDatetime;
            return this;
        }

        public Builder setSort(boolean sort) {
            this.sort = sort;
            return this;
        }

        public Builder setStart(Double start) {
            this.start = start;
            return this;
        }

        public Builder setEnd(Double end) {
            this.end = end;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public SearchServiceImpl build() {
            if (index == null || index.equals(""))
                throw new IllegalStateException("miss index");
            else if (type == null || type.equals(""))
                throw new IllegalStateException("miss type");
            else if (username == null || username.equals(""))
                throw new IllegalStateException("miss username");
            if (id == null || id.equals(""))
                throw new IllegalStateException("miss id");
            else {
                return new SearchServiceImpl(this);
            }
        }
    }
}

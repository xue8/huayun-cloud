package cn.ddnd.huayun.web.request;

import cn.ddnd.huayun.web.config.Global;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class MonitorRequest {

    private Builder builder;

    MonitorRequest(Builder builder) {
        this.builder = builder;
    }

    /**
      * 监控请求
     */
    public String getRequest() {
        String json = "{\n" +
                "    \"actions\":{\n" +
                "        \"webhook\":{\n" +
                "            \"webhook\":{\n" +
                "                \"method\":\""
                + builder.method +
                "\",\n" +
                "                \"host\":\""
                + builder.host +
                "\",\n" +
                "                \"port\":"
                + builder.port +
                ",\n" +
                "                \"path\":\""
                + builder.path +
                "\",\n" +
                "                \"body\":\""
                + builder.body +
                "\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"input\":{\n" +
                "        \"search\":{\n" +
                "            \"request\":{\n" +
                "            \t\"indices\" : [ \""
                + builder.index +
                "\" ],\n" +
                "                \"body\":{\n" +
                "                    \"query\":{\n" +
                "                        \"bool\":{\n" +
                "                            \"must\":[\n" +
                "                                {\n" +
                "                                    \"match_phrase\":{\n" +
                "                                        \"id\":\""
                + builder.id +
                "\"\n" +
                "                                    }\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"match_phrase\":{\n" +
                "                                        \"username\":\""
                + builder.username +
                "\"\n" +
                "                                    }\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"filter\": [\n" +
                "                                {\n" +
                "                                    \"range\":{\n" +
                "                                        \"datetime\":{\n" +
                "                                            \"gte\": \""
                + builder.startTime +
                "\",\n" +
                "                                            \"lte\": \""
                + builder.endTime +
                "\"\n" +
                "                                        }\n" +
                "                                    }            \t\t\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"range\":{\n" +
                "                                        \"used\":{\n" +
                "                                            \"gte\": "
                + builder.used +
                "\n" +
                "                                        }\n" +
                "                                    }            \t\t\n" +
                "                                }           \t\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"condition\":{\n" +
                "        \"compare\":{\n" +
                "            \"ctx.payload.hits.total\":{\n" +
                "                \"gt\":0\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"trigger\":{\n" +
                "        \"schedule\":{\n" +
                "            \"interval\":\"s"
                + builder.minute +
                "\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return json;
    }

    public String getUrl() {
        String url = Global.elasticsearchMonitorUrl;
        url += builder.monitorName;

        return url;
    }

    public static class Builder {
        private String host;
        private Integer port = 80;
        private String path = "/monitor";
        private String method = "PUT";
        private String index;
        private String id;
        private String username;
        private Integer minute = 30;
        private String startTime = null;
        private String endTime = null;
        private Double used = 50D;
        private String monitorName;
        private String body = "{{ctx.payload.hits.hits}}";

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(Integer port) {
            this.port = port;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder setIndex(String index) {
            this.index = index;
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

        public Builder setMinute(Integer minute) {
            this.minute = minute;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setUsed(Double used) {
            this.used = used;
            return this;
        }

        public Builder setMonitorName(String monitorName) {
            this.monitorName = monitorName;
            return this;
        }

        public MonitorRequest build() {
            if (host == null || index == null || id == null || username == null || monitorName == null)
                throw new RuntimeException("monitor request parameter is null");
            return new MonitorRequest(this);
        }

        public Builder setBody(String body) {
            Map map = new HashMap();
            map.put("data", this.body);
            map.put("type", body);
            this.body = JSON.toJSONString(map);
            return this;
        }
    }
}

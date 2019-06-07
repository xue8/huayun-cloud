package cn.ddnd.huayun.es.parse;

import cn.ddnd.huayun.es.pojo.CloudInfo;
import cn.ddnd.huayun.es.pojo.ElasticsearchResponse;
import com.alibaba.fastjson.JSON;
import io.searchbox.core.SearchResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ElasticsearchParse {

    /**
      * 解析数据
     */
    public List<CloudInfo> parse(SearchResult searchResult) {
        try {
            List<CloudInfo> result = new ArrayList<>();
            ElasticsearchResponse response1 = JSON.parseObject(searchResult.getJsonString(), ElasticsearchResponse.class);
            Map map = (Map) response1.getHits();
            List<Object> list = (List<Object>) map.get("hits");
            for (Object object : list) {
                Object ob = ((Map) object).get("_source");
                String s = String.valueOf(ob);
                CloudInfo cloudInfo = JSON.parseObject(s, CloudInfo.class);
                result.add(cloudInfo);
            }
            return result;
        } catch (NullPointerException e) {
            return null;
        }
    }

}

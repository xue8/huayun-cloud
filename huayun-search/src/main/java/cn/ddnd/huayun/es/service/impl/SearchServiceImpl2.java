package cn.ddnd.huayun.es.service.impl;

import cn.ddnd.huayun.es.parse.ElasticsearchParse;
import cn.ddnd.huayun.es.pojo.CloudInfo;
import cn.ddnd.huayun.es.service.ElasticsearchSearchService2;
import cn.ddnd.huayun.es.service.SearchService;
import com.alibaba.dubbo.config.annotation.Service;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Service
public class SearchServiceImpl2 implements SearchService {

    @Autowired
    ElasticsearchSearchService2 searchService2;
    @Autowired
    ElasticsearchParse parse;

    @Override
    public List<CloudInfo> search(String index, String type, String username, String id, boolean sort) {
        SearchResult result = searchService2.searchByDefault(index, type, username, id, sort);
        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> searchBystartDatetime(String index, String type, String username, String id, String startDatetime, boolean sort) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String date = format.format(new Date());
        String endDatetime = date;
        SearchResult result = searchService2.searchByDatetimeRange(index, type, username, id, startDatetime, endDatetime,
                sort);
        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> searchByEndDatetime(String index, String type, String username, String id, String endDatetime, boolean sort) {
        SearchResult result = searchService2.searchByDatetimeRange(index, type, username, id, "0", endDatetime,
                sort);

        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> search(String index, String type, String username, String id, String startDatetime, String endDatetime, boolean sort) {
        SearchResult result = searchService2.searchByDatetimeRange(index, type, username, id, startDatetime, endDatetime,
                sort);

        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> search(String index, String type, String username, String id, Double start, Double end, boolean sort) {
        SearchResult result = searchService2.searchByUsedRange(index, type, username, id, start, end,
                sort);

        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> search(String index, String type, String username, String id, String startDatetime, String endDatetime, Double start, Double end, boolean sort) {
        SearchResult result = searchService2.searchByDatetimeAndUsedRange(index, type, username, id, startDatetime, endDatetime,
                start, end ,sort);

        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> searchByStart(String index, String type, String username, String id, Double start, boolean sort) {
        SearchResult result = searchService2.searchByUsedRange(index, type, username, id, start, 100D,
                sort);

        return parse.parse(result);
    }

    @Override
    public List<CloudInfo> searchByEnd(String index, String type, String username, String id, Double end, boolean sort) {
        SearchResult result = searchService2.searchByUsedRange(index, type, username, id, 0D, end,
                sort);

        return parse.parse(result);
    }
}

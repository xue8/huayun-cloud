package cn.ddnd.huayun.es.service.impl;

import cn.ddnd.huayun.es.ioc.ApplicationUtil;
import cn.ddnd.huayun.es.service.ElasticsearchSearchService2;
import cn.ddnd.huayun.es.service.ElasticsearchService;
import io.searchbox.core.SearchResult;
import org.springframework.stereotype.Service;

/**
 * @program: huayun
 * @description: 云服务器Cpu文档相关操作
 * @author: Xue 8
 * @create: 2019-05-23 12:46
 **/

@Service
public class ElasticsearchSearchServiceImpl2 implements ElasticsearchSearchService2 {

    ElasticsearchService elasticsearchDao;


    public ElasticsearchSearchServiceImpl2() {
        this.elasticsearchDao = (ElasticsearchServiceImpl) ApplicationUtil.getBean(ElasticsearchServiceImpl.class);
    }

    @Override
    public SearchResult searchByDatetimeRange(String index, String type, String username, String id,
                                              String startDatetime, String endDatetime,boolean sort) {
        String query = null;
        if (sort) {
            query = "{\n" +
                    "\t\"size\" : 500,\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + id +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + username +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"datetime\" : {\n" +
                    "                    \t\"gte\" : \""
                    + startDatetime +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + endDatetime +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    }\n" +
                    ",\n" +
                   "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t},\n" +
                    "    \t{\n" +
                    "    \t\t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\t\n" +
                    "    ]\n" +
                    " }";
        } else {
            query = "{\n" +
                    "\t\"size\" : 500,\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + id +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + username +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"datetime\" : {\n" +
                    "                    \t\"gte\" : \""
                    + startDatetime +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + endDatetime +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    },\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\n" +
                    "    ]\n" +
                    " }";
        }
        return elasticsearchDao.search(index, type, query);
    }

    @Override
    public SearchResult searchByUsedRange(String index, String type, String username, String id,Double start, Double end,
                                          boolean sort) {
        String query = null;
        if (sort) {
            query = "{\n" +
                    "\t\"size\" : 500,\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + id +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + username +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"used\" : {\n" +
                    "                    \t\"gte\" : \""
                    + start +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + end +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    }\n" +
                    ",\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t},\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\t\n" +
                    "    ]\n" +
                    " }";
        } else {
            query = "{\n" +
                    "\t\"size\" : 500,\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + id +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + username +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"used\" : {\n" +
                    "                    \t\"gte\" : \""
                    + start +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + end +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    },\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\n" +
                    "    ]\n" +
                    " }";
        }
        return elasticsearchDao.search(index, type, query);
    }

    @Override
    public SearchResult searchByDatetimeAndUsedRange(String index, String type, String username, String id, String startDatetime,
                                                     String endDatetime, Double start, Double end, boolean sort) {
        String query = null;
        if (sort) {
            query = "{\n" +
                    "\t\"size\" : 500,\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + id +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + username +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : [\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"datetime\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : \""
                    + startDatetime +
                    "\",\n" +
                    "    \t\t\t\t\t\t\"lte\" : \""
                    + endDatetime +
                    "\"\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"used\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : "
                    + start +
                    ",\n" +
                    "    \t\t\t\t\t\t\"lte\" : "
                    + end +
                    "\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t]\n" +
                    "    \t}\n" +
                    "    },\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t},\n" +
                    "    \t{\n" +
                    "    \t\t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\t\n" +
                    "    ]\n" +
                    " }";
        } else {
            query = "{\n" +
                    "\t\"size\" : 500,\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + id +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + username +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : [\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"datetime\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : \""
                    + startDatetime +
                    "\",\n" +
                    "    \t\t\t\t\t\t\"lte\" : \""
                    + endDatetime +
                    "\"\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"used\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : "
                    + start +
                    ",\n" +
                    "    \t\t\t\t\t\t\"lte\" : "
                    +end +
                    "\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t]\n" +
                    "    \t}\n" +
                    "    },\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t},\n" +
                    "    \t{\n" +
                    "    \t\t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\t\n" +
                    "    ]\n" +
                    " }";
        }
        return elasticsearchDao.search(index, type, query);
    }

    @Override
    public SearchResult searchByDefault(String index, String type, String username, String id, boolean sort) {

        String query = null;
        if (sort) {
            query = "{\n" +
                    "\t\"size\" : 100,\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t},\n" +
                    "    \t{\n" +
                    "    \t\t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\t\n" +
                    "    ]\n" +
                    " }";
        } else {
            query = "{\n" +
                    "\t\"size\" : 100,\n" +
                    "    \"sort\" : [\n" +
                    "    \t{\n" +
                    "    \t\t\"datetime\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t\t}\n" +
                    "    \t}\n" +
                    "    ]\n" +
                    " }";
        }
        return elasticsearchDao.search(index, type, query);
    }
}

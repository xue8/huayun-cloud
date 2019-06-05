package cn.ddnd.huayun.es.service.impl;

import cn.ddnd.huayun.es.service.ElasticsearchService;
import cn.ddnd.huayun.es.service.ElasticsearchSearchService;
import cn.ddnd.huayun.es.ioc.ApplicationUtil;
import io.searchbox.core.SearchResult;

/**
 * @program: huayun
 * @description: 云服务器Cpu文档相关操作
 * @author: Xue 8
 * @create: 2019-05-23 12:46
 **/

public class ElasticsearchSearchServiceImpl implements ElasticsearchSearchService {

    ElasticsearchService elasticsearchDao;
    SearchServiceImpl searchDao;

    public ElasticsearchSearchServiceImpl(SearchServiceImpl searchDao) {
        this.elasticsearchDao = (ElasticsearchServiceImpl) ApplicationUtil.getBean(ElasticsearchServiceImpl.class);
        this.searchDao = searchDao;
    }

    @Override
    public SearchResult searchByDatetimeRange() {
        String query = null;
        if (searchDao.isSort()) {
            query = "{\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + searchDao.getId() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + searchDao.getUsername() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"datetime\" : {\n" +
                    "                    \t\"gte\" : \""
                    + searchDao.getStartDatetime() +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + searchDao.getEndDatetime() +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    }\n" +
                    ",\n" +
                    "    \"sort\" : {\n" +
                    "    \t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t}\n" +
                    "    }" +
                    "}";
        } else {
            query = "{\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + searchDao.getId() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + searchDao.getUsername() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"datetime\" : {\n" +
                    "                    \t\"gte\" : \""
                    + searchDao.getStartDatetime() +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + searchDao.getEndDatetime() +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    }\n" +
                    "}";
        }
        return elasticsearchDao.search(searchDao.getIndex(), searchDao.getType(), query);
    }

    @Override
    public SearchResult searchByUsedRange() {
        String query = null;
        if (searchDao.isSort()) {
            query = "{\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + searchDao.getId() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + searchDao.getUsername() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"used\" : {\n" +
                    "                    \t\"gte\" : \""
                    + searchDao.getStart() +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + searchDao.getEnd() +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    }\n" +
                    ",\n" +
                    "    \"sort\" : {\n" +
                    "    \t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t}\n" +
                    "    }" +
                    "}";
        } else {
            query = "{\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + searchDao.getId() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + searchDao.getUsername() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : { \n" +
                    "                \"range\" : {\n" +
                    "                    \"used\" : {\n" +
                    "                    \t\"gte\" : \""
                    + searchDao.getStart() +
                    "\",\n" +
                    "                    \t\"lte\" : \""
                    + searchDao.getEnd() +
                    "\"\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\t\t\t}\n" +
                    "    \t}\n" +
                    "    }\n" +
                    "}";
        }
        return elasticsearchDao.search(searchDao.getIndex(), searchDao.getType(), query);
    }

    @Override
    public SearchResult searchByDatetimeAndUsedRange() {
        String query = null;
        if (searchDao.isSort()) {
            query = "{\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + searchDao.getId() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + searchDao.getUsername() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : [\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"datetime\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : \""
                    + searchDao.getStartDatetime() +
                    "\",\n" +
                    "    \t\t\t\t\t\t\"lte\" : \""
                    + searchDao.getEndDatetime() +
                    "\"\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"used\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : "
                    + searchDao.getStart() +
                    ",\n" +
                    "    \t\t\t\t\t\t\"lte\" : "
                    + searchDao.getEnd() +
                    "\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t]\n" +
                    "    \t}\n" +
                    "    },\n" +
                    "    \"sort\" : {\n" +
                    "    \t\"used\" : {\n" +
                    "    \t\t\"order\" : \"desc\"\n" +
                    "    \t}\n" +
                    "    }\n" +
                    "}";
        } else {
            query = "{\n" +
                    "    \"query\" : {\n" +
                    "    \t\"bool\" : {\n" +
                    "    \t\t\"must\" : [\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"id\" : \""
                    + searchDao.getId() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "\t\t\t\t{\n" +
                    "\t    \t\t\t\"match\" : {\n" +
                    "\t    \t\t\t\t\"username\" : \""
                    + searchDao.getUsername() +
                    "\"\n" +
                    "\t    \t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t],\n" +
                    "    \t\t\"filter\" : [\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"datetime\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : \""
                    + searchDao.getStartDatetime() +
                    "\",\n" +
                    "    \t\t\t\t\t\t\"lte\" : \""
                    + searchDao.getEndDatetime() +
                    "\"\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t},\n" +
                    "    \t\t\t{\n" +
                    "    \t\t\t\t\"range\" : {\n" +
                    "    \t\t\t\t\t\"used\" : {\n" +
                    "    \t\t\t\t\t\t\"gte\" : "
                    + searchDao.getStart() +
                    ",\n" +
                    "    \t\t\t\t\t\t\"lte\" : "
                    + searchDao.getEnd() +
                    "\n" +
                    "    \t\t\t\t\t}\n" +
                    "    \t\t\t\t}\n" +
                    "    \t\t\t}\n" +
                    "\t\t\t]\n" +
                    "    \t}\n" +
                    "    }\n" +
                    "}";
        }
        return elasticsearchDao.search(searchDao.getIndex(), searchDao.getType(), query);
    }

    @Override
    public SearchResult searchByDefault() {

        String query = null;
        if (searchDao.isSort()) {
            query = "{\n" +
                    "\t\"size\" : 100,\n" +
                    "\t\"sort\" : {\n" +
                    "\t\t\"datetime\" : {\n" +
                    "\t\t\t\"order\" : \"desc\"\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "}";
        } else {
            query = "{\n" +
                    "\t\"size\" : 100\n" +
                    "}";
        }
        return elasticsearchDao.search(searchDao.getIndex(), searchDao.getType(), query);
    }
}

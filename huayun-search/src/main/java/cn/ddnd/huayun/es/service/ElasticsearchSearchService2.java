package cn.ddnd.huayun.es.service;

import io.searchbox.core.SearchResult;

public interface ElasticsearchSearchService2 {
    SearchResult searchByDatetimeRange(String index, String type, String username, String id,
                                       String startDatetime, String endDatetime,boolean sort);
    SearchResult searchByUsedRange(String index, String type, String username, String id,Double start, Double end,
                                   boolean sort);
    SearchResult searchByDatetimeAndUsedRange(String index, String type, String username, String id, String startDatetime,
                                              String endDatetime, Double start, Double end, boolean sort);
    SearchResult searchByDefault(String index, String type, String username, String id, boolean sort);
}

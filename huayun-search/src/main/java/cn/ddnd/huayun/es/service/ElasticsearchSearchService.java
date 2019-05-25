package cn.ddnd.huayun.es.service;

import io.searchbox.core.SearchResult;

public interface ElasticsearchSearchService {
    SearchResult searchByDatetimeRange();
    SearchResult searchByUsedRange();
    SearchResult searchByDatetimeAndUsedRange();
    SearchResult searchByDefault();
}

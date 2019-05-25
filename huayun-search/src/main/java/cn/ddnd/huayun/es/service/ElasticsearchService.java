package cn.ddnd.huayun.es.service;

import io.searchbox.core.SearchResult;

public interface ElasticsearchService {
    boolean createIndex(String indexName);
    boolean deleteInedx(String indexName);
    boolean createIndexMapping(String indexName, String typeName, Object source);
    String getIndexMapping(String indexName, String typeName);
    SearchResult search(String indexName, String typeName, String query);
    Double count(String indexName, String typeName, String query);
    boolean deleteDocument(String indexName, String typeName, String id);
    boolean addDocument(String indexName, String typeName, Object source);
}

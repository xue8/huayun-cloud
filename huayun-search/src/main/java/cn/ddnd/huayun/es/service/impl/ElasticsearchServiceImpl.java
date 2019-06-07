package cn.ddnd.huayun.es.service.impl;

import cn.ddnd.huayun.es.service.ElasticsearchService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ElasticsearchServiceImpl implements ElasticsearchService {

    @Autowired
    JestClient jestClient;

    @Override
    public boolean createIndex(String indexName) {
        CreateIndex index = new CreateIndex.Builder(indexName).build();
        try {
            JestResult result = jestClient.execute(index);
            return result.isSucceeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteInedx(String indexName) {
        DeleteIndex index = new DeleteIndex.Builder(indexName).build();
        try {
            JestResult result = jestClient.execute(index);
            return result.isSucceeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createIndexMapping(String indexName, String typeName, Object source) {
        PutMapping putMapping = new PutMapping.Builder(indexName, typeName, source).build();
        try {
            JestResult result = jestClient.execute(putMapping);
            return result.isSucceeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getIndexMapping(String indexName, String typeName) {
        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
        try {
            JestResult result = jestClient.execute(getMapping);
            return result.getJsonString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SearchResult search(String indexName, String typeName, String query) {
        Search search = new Search.Builder(query).addIndex(indexName).addType(typeName).build();
        try {
            SearchResult result = jestClient.execute(search);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Double count(String indexName, String typeName, String query) {
        Count count = new Count.Builder().query(query).addIndex(indexName).addType(typeName).build();
        try {
            CountResult result = jestClient.execute(count);
            return result.getCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteDocument(String indexName, String typeName, String id) {
        Delete delete = new Delete.Builder(id).index(indexName).type(typeName).build();
        try {
            DocumentResult result = jestClient.execute(delete);
            return result.isSucceeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addDocument(String indexName, String typeName, Object source) {
        Index index = new Index.Builder(source).type(typeName).index(indexName).build();
        try {
            JestResult result = jestClient.execute(index);
            return result.isSucceeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

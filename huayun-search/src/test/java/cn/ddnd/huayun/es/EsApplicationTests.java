package cn.ddnd.huayun.es;

import cn.ddnd.huayun.es.service.ElasticsearchService;
import cn.ddnd.huayun.es.mapper.CloudMapper;
import cn.ddnd.huayun.es.service.SearchService;
import cn.ddnd.huayun.es.service.impl.SearchServiceImpl2;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import io.searchbox.client.JestClient;
import io.searchbox.indices.CreateIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableElasticsearchRepositories
@EnableDubbo
public class EsApplicationTests {

    @Autowired
    SearchService searchService;
    @Autowired
    SearchServiceImpl2 searchServiceImpl2;

    @Test
    public void contextLoads() {
        Object o = searchService.search("cloud_cpu", "_doc", "xue8",
                "i-zz6rj39kty724", true);
        System.out.println();
    }


}
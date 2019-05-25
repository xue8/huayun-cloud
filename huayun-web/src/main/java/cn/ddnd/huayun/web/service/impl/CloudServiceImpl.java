package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.pojo.CloudInfo;
import cn.ddnd.huayun.web.pojo.CloudRequest;
import cn.ddnd.huayun.web.service.CloudService;
import cn.ddnd.huayun.es.service.SearchService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CloudServiceImpl implements CloudService {

    @Reference
    SearchService searchService;

    @Override
    @Cacheable("cloud")
    public List<CloudInfo> search(CloudRequest request) {
        List<CloudInfo> list = new ArrayList<>();

        if (request.getStartDatetime() == null && request.getEndDatetime() == null
                && request.getStart() == null && request.getEnd() == null) {
            list = searchService.search(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() == null && request.getEndDatetime() == null
                    && request.getStart() == null) {
            list = searchService.searchByEnd(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getEnd() ,request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() == null && request.getEndDatetime() == null
                && request.getEnd() == null) {
            list = searchService.searchByStart(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getStart(), request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() == null && request.getEndDatetime() == null
                && request.getEnd() != null && request.getStart() != null) {
            list = searchService.search(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getStart(), request.getEnd(), request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() != null && request.getEndDatetime() != null
                && request.getEnd() != null && request.getStart() != null) {
            list = searchService.search(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getStartDatetime(), request.getEndDatetime(),
                    request.getStart(), request.getEnd(), request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() != null && request.getEndDatetime() == null) {
            list = searchService.searchBystartDatetime(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getStartDatetime(), request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() == null && request.getEndDatetime() != null) {
            list = searchService.searchByEndDatetime(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getEndDatetime(), request.isSort());
            if (list.size() != 0)
                return list;
        }
        if (request.getStartDatetime() != null && request.getEndDatetime() != null) {
            list = searchService.search(request.getIndex(), request.getType(), request.getUsername(),
                    request.getId(), request.getStartDatetime(), request.getEndDatetime(),
                    request.isSort());
            if (list.size() != 0)
                return list;
        }
        return list;
    }

}

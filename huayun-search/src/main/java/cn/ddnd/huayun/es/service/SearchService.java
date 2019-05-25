package cn.ddnd.huayun.es.service;

import cn.ddnd.huayun.es.pojo.CloudInfo;

import java.util.List;

public interface SearchService {
    List<CloudInfo> search(String index, String type, String username, String id, boolean sort);
    List<CloudInfo> searchBystartDatetime(String index, String type, String username, String id, String startDatetime, boolean sort);
    List<CloudInfo> searchByEndDatetime(String index, String type, String username, String id, String endDatetime, boolean sort);
    List<CloudInfo> search(String index, String type, String username, String id, String startDatetime,
                  String endDatetime, boolean sort);
    List<CloudInfo> search(String index, String type, String username, String id,Double start, Double end,
                  boolean sort);
    List<CloudInfo> search(String index, String type, String username, String id, String startDatetime,
                  String endDatetime, Double start, Double end, boolean sort);
    List<CloudInfo> searchByStart(String index, String type, String username, String id, Double start,
                  boolean sort);
    List<CloudInfo> searchByEnd(String index, String type, String username, String id, Double end,
                         boolean sort);
}

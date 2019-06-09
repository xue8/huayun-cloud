package cn.ddnd.huayun.web.service;

import cn.ddnd.huayun.web.pojo.LoginInfo;

import java.util.List;

public interface LoginInfoService {
    boolean insertMember(LoginInfo info);
    List<LoginInfo> findMemberByUsername(String username);
}

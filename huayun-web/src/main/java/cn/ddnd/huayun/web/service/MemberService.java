package cn.ddnd.huayun.web.service;

import cn.ddnd.huayun.web.pojo.Members;

public interface MemberService {
    boolean insertMember(Members members);
    Members findMemberByUsername(String username);
    boolean updateMember(Members members);
}

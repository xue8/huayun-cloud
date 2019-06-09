package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.mapper.MembersMapper;
import cn.ddnd.huayun.web.pojo.Members;
import cn.ddnd.huayun.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MembersMapper membersMapper;

    @Override
    public boolean insertMember(Members members) {
        return membersMapper.insertMember(members);
    }

    @Override
    public Members findMemberByUsername(String username) {
        Members members = new Members();
        members.setUsername(username);
        return membersMapper.findMemberByUsername(members);
    }

    @Override
    public boolean updateMember(Members members) {
        return membersMapper.updateMember(members);
    }

}

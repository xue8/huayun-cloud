package cn.ddnd.huayun.web.service.impl;

import cn.ddnd.huayun.web.mapper.LoginInfoMapper;
import cn.ddnd.huayun.web.pojo.LoginInfo;
import cn.ddnd.huayun.web.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    @Autowired
    LoginInfoMapper loginInfoMapper;

    @Override
    public boolean insertMember(LoginInfo info) {
        loginInfoMapper.insertLoginInfo(info);
        return false;
    }

    @Override
    public List<LoginInfo> findMemberByUsername(String username) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(username);
        return loginInfoMapper.findLoginInfoByUsername(loginInfo);
    }
}

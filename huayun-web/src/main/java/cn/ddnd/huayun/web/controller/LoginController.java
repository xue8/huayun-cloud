package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.pojo.LoginInfo;
import cn.ddnd.huayun.web.pojo.Members;
import cn.ddnd.huayun.web.service.CheckIdentityService;
import cn.ddnd.huayun.web.service.LoginInfoService;
import cn.ddnd.huayun.web.service.MemberService;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user/")
public class LoginController {

    @Autowired
    CheckIdentityService service;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    MemberService memberService;
    @Autowired
    LoginInfoService loginInfoService;
    @Autowired
    OkHttpClient okHttpClient;

    @PostMapping("login")
    public String login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpServletRequest request,
                         HttpSession session) {
        Members members = new Members();
        members.setUsername(username);
        members.setPassword(password);
        Members members1 = memberService.findMemberByUsername(username);
        if (members1 == null)
            return "{\"error\":\"用户不存在\"}";
        if (!members1.getPassword().equals(password))
            return "{\"error\":\"密码不正确\"}";
        Map map = new HashMap<>();
        map.put("accessKeyId", "b413a44216fb4b7ca709368b50937f54");
        map.put("accessKey", "003193565fef41459f8719bad5951082");
        stringRedisTemplate.opsForHash().putAll("user:" + session.getId(), map);
        stringRedisTemplate.expire("user:" + session.getId(), 30, TimeUnit.MINUTES);

        String ip = request.getRemoteAddr();
        Request request1 = new Request.Builder()
                .url("http://ip-api.com/json/" + ip + "?lang=zh-CN")
                .get()
                .build();
        try {
            Response response = okHttpClient.newCall(request1).execute();
            String var1 = response.body().string();
            Map map1 = JSON.parseObject(var1, Map.class);
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setUsername(username);
            loginInfo.setCity(String.valueOf(map1.get("regionName")) + String.valueOf(map1.get("city")));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            loginInfo.setDatetime(format.format(new Date()));
            loginInfo.setIsp(String.valueOf(map1.get("isp")));
            if (map1.get("status").equals("fail")) {
                loginInfo.setCity("内网IP");
                loginInfo.setIsp("内网IP");
            }
            loginInfoService.insertMember(loginInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"sessionId\":\"" + session.getId() + "\"}";
    }


    @PostMapping("register")
    public String register(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Members members = new Members();
        members.setUsername(username);
        members.setPassword(password);
        Members members1 = memberService.findMemberByUsername(username);
        if (members1 != null) {
            return "{\"error\":\"用户已存在\"}";
        }
        memberService.insertMember(members);
        return "{\"error\":\"注册成功\"}";
    }

    @PostMapping("update")
    public String update(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("email") String email,
                        @RequestParam("phone") String phone,
                        @RequestParam("keyId") String keyId,
                        @RequestParam("keySecret") String keySecret,
                        HttpSession session) {
        Map map = new HashMap<>();
        map.put("accessKeyId", keyId);
        map.put("accessKey", keySecret);
        stringRedisTemplate.opsForHash().putAll("user:" + session.getId(), map);
        stringRedisTemplate.expire("user:" + session.getId(), 30, TimeUnit.MINUTES);
        Members members = new Members();
        members.setUsername(username);
        members.setPassword(password);
        members.setEmail(email);
        members.setPhone(phone);
        members.setKeyId(keyId);
        members.setKeySecret(keySecret);
        memberService.updateMember(members);
        return "{\"error\":\"更新成功\"}";
    }

    @GetMapping("query")
    public Object query(@RequestParam("username") String username,
                        HttpSession session) {
        return memberService.findMemberByUsername(username);
    }

    @GetMapping("loginInfo")
    public Object loginInfo(@RequestParam("username") String username,
                        HttpSession session) {
        return loginInfoService.findMemberByUsername(username);
    }

}

package cn.ddnd.huayun.web.aspect;

import cn.ddnd.huayun.web.exception.AuthenticationFailureException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class CheckAuthentication {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    HttpSession session;

    /**
     * 代理除了登录的controller，进行身份验证
     */
    @Pointcut(value = "execution(public * cn.ddnd.huayun.web.controller.*.*(..)) " +
            "&& !execution(public * cn.ddnd.huayun.web.controller.LoginController.*(..))")
    public void controller() {
    }

    @Before(value = "controller()")
    public void cheak() {
        String sessionId = session.getId();
        if (!stringRedisTemplate.hasKey("user:" + sessionId))
            throw new AuthenticationFailureException();
        return;
    }

}

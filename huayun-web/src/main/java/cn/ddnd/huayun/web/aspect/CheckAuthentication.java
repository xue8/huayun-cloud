package cn.ddnd.huayun.web.aspect;

import cn.ddnd.huayun.web.exception.AuthenticationFailureException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class CheckAuthentication {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    HttpSession session;

    /**
     * 对除了登录的 controller 进行身份验证
     */
    @Pointcut(value = "execution(public * cn.ddnd.huayun.web.controller.*.*(..)) " +
            "&& !execution(public * cn.ddnd.huayun.web.controller.LoginController.login(..))" +
            "&& !execution(public * cn.ddnd.huayun.web.controller.LoginController.register(..))")
    public void controller() {
    }

    @Before(value = "controller()")
    public void check() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String sessionId = request.getHeader("sessionId");
        if (!stringRedisTemplate.hasKey("user:" + sessionId))
            throw new AuthenticationFailureException();
    }

}

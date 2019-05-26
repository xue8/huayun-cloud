package cn.ddnd.huayun.web.handler;

import cn.ddnd.huayun.web.exception.AuthenticationFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AuthenticationFailureHandler {

    /**
     * 身份验证失败
     * @return 返回 Authentication failure
     */
    @ExceptionHandler(AuthenticationFailureException.class)
    @ResponseBody
    public String handler() {
        return "{\"error\":\"Authentication failure\"}";
    }

}

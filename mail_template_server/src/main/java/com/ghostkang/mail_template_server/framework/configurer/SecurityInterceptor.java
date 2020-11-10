package com.ghostkang.mail_template_server.framework.configurer;

import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.framework.result.ResultCode;
import com.ghostkang.mail_template_server.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

/**
 * @Author: GhostKang
 * @Date: 2020/11/6 15:12
 * @Description:
 * @Version: 1.0
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            throw new ServiceException(ResultCode.UNAUTHORIZED.code(), ResultCode.UNAUTHORIZED.msg());
        }
        String result = redisService.get(accessToken);
        if (StringUtils.isEmpty(result)) {
            throw new ServiceException(ResultCode.UNAUTHORIZED.code(), ResultCode.UNAUTHORIZED.msg());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

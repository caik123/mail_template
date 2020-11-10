package com.ghostkang.mail_template_server.framework.exception;

import com.ghostkang.mail_template_server.bean.BaseResp;
import com.ghostkang.mail_template_server.framework.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResp handleException(Exception e) {
        logger.error(e.getMessage());
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(ResultCode.FAIL.code());
        baseResp.setMsg(ResultCode.FAIL.msg());
        if (e instanceof ServiceException) {
            baseResp.setCode(((ServiceException) e).getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }
}
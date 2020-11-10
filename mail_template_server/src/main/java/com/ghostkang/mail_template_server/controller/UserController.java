package com.ghostkang.mail_template_server.controller;

import com.ghostkang.mail_template_server.bean.*;
import com.ghostkang.mail_template_server.bean.login.Request;
import com.ghostkang.mail_template_server.bean.login.Response;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 信息操作处理
 *
 * @author GhostKang
 * @date 2020-11-06 10:50:42
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public BaseResp login(@RequestBody Request request) {
        BaseResp baseResp = new BaseResp();
        try {
            String accessToken = userService.login(request);
            Response response = new Response();
            response.setAccessToken(accessToken);
            baseResp.setData(response);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    @PostMapping("/getVerifyCode")
    @ResponseBody
    public BaseResp verifyCode(@RequestBody com.ghostkang.mail_template_server.bean.verifycode.Request request) {
        BaseResp baseResp = new BaseResp();
        String verifyCode = null;
        try {
            verifyCode = userService.getVerifyCode(request.getCellphone());
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        com.ghostkang.mail_template_server.bean.verifycode.Response response = new com.ghostkang.mail_template_server.bean.verifycode.Response();
        response.setVerifyCode(verifyCode);
        baseResp.setData(response);
        return baseResp;
    }

}

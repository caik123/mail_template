package com.ghostkang.mail_template_server.service;

import com.ghostkang.mail_template_server.bean.login.Request;
import com.ghostkang.mail_template_server.domain.User;
import com.ghostkang.mail_template_server.framework.core.Service;

/**
 * 服务层
 *
 * @author GhostKang
 * @date 2020-11-06 10:50:42
 */
public interface UserService extends Service<User> {

    /***
     * 注册用户
     * @param cellphone cellphone
     * @param code 验证码
     * @return
     */
    int registerUser(String cellphone, String code);

    /***
     * 登录
     * @return accessToken
     */
    String login(Request request);

    String getVerifyCode(String cellphone);
}

package com.ghostkang.mail_template_server.service.impl;


import com.alibaba.fastjson.JSON;
import com.ghostkang.mail_template_server.bean.login.Request;
import com.ghostkang.mail_template_server.dao.UserDao;
import com.ghostkang.mail_template_server.domain.User;
import com.ghostkang.mail_template_server.framework.core.AbstractService;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.framework.result.ResultCode;
import com.ghostkang.mail_template_server.service.RedisService;
import com.ghostkang.mail_template_server.service.UserService;
import com.ghostkang.mail_template_server.util.SnowflakeIdWorker;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

/**
 * 服务层实现
 *
 * @author GhostKang
 * @date 2020-11-06 10:50:42
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDao userDao;

    @Override
    public int registerUser(String cellphone, String code) {
        User user = new User();
        user.setCellphonoe(cellphone);
        int count = userDao.selectCount(user);
        if (count == 0) {
            String keepCode = redisService.get(cellphone);
            if (StringUtils.isEmpty(keepCode)) {
                throw new ServiceException(ResultCode.CODE_TIMEOUT.code(), ResultCode.CODE_TIMEOUT.msg());
            }
            if (!keepCode.equals(code)) {
                throw new ServiceException(ResultCode.CODE_ERROR.code(), ResultCode.CODE_ERROR.msg());
            }
            user.setUsername(cellphone);
            user.setCreated(new Date());
            user.setUpdated(new Date());
            return userDao.insertSelective(user);
        } else {
            throw new ServiceException(ResultCode.USER_EXSIT.code(), ResultCode.USER_EXSIT.msg());
        }
    }

    @Override
    public String login(Request request) {
        String accessToken = "";
        if (request.getType() == 1) {//账号密码登录
            User user = new User();
            user.setUsername(request.getUsername());
            int count = userDao.selectCount(user);
            if (count == 0) {
                throw new ServiceException(ResultCode.USER_NOT_EXSIT.code(), ResultCode.USER_NOT_EXSIT.msg());
            }
            user.setPassword(request.getPassword());
            count = userDao.selectCount(user);
            if (count == 0) {
                throw new ServiceException(ResultCode.PASSWORD_ERROR.code(), ResultCode.PASSWORD_ERROR.msg());
            }
        } else {//验证码登录
            User user = new User();
            user.setCellphonoe(request.getUsername());
            int count = userDao.selectCount(user);
            //未注册
            if (count == 0 && !StringUtils.isEmpty(request.getPassword())) {
                int i = registerUser(request.getUsername(), request.getPassword());
                if (i > 0) {
                    accessToken = setAccessToken(request.getUsername());
                }
            } else {
                //已注册
                String verifyCode = redisService.get(request.getUsername());
                logger.error("verifyCode:" + verifyCode);
                if (StringUtils.isEmpty(verifyCode)) {
                    throw new ServiceException(ResultCode.CODE_TIMEOUT.code(), ResultCode.CODE_TIMEOUT.msg());
                }
                if (!verifyCode.equals(request.getPassword())) {
                    throw new ServiceException(ResultCode.CODE_ERROR.code(), ResultCode.CODE_ERROR.msg());
                }
                accessToken = setAccessToken(request.getUsername());
            }
        }
        return accessToken;
    }

    private String setAccessToken(String username) {
        String accessToken;
        User user = new User();
        user.setUsername(username);
        user = userDao.selectOne(user);
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        long l = idWorker.nextId();
        accessToken = String.valueOf(l);
        redisService.set(accessToken, JSON.toJSONString(user));
        return accessToken;
    }

    @Override
    public String getVerifyCode(String cellphone) {
        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        redisService.set(cellphone, code);
        redisService.expire(cellphone, 10);
        logger.error("code:" + code);
        return code;
    }
}

package com.ghostkang.mail_template_server.controller;

import com.ghostkang.mail_template_server.bean.BaseResp;
import com.ghostkang.mail_template_server.bean.param_val.AddRequest;
import com.ghostkang.mail_template_server.bean.param_val.DeleteRequest;
import com.ghostkang.mail_template_server.bean.param_val.EditRequest;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.service.ParamValService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分类参数 信息操作处理
 *
 * @author GhostKang
 * @date 2020-11-06 17:22:53
 */
@Controller
@RequestMapping("/param_vals")
public class ParamValsController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParamValService paramValService;


    @PostMapping("/add")
    @ResponseBody
    public BaseResp add(@RequestBody AddRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            paramValService.add(request);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    @PostMapping("/edit")
    @ResponseBody
    public BaseResp edit(@RequestBody EditRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            paramValService.edit(request);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    @PostMapping("/delete")
    @ResponseBody
    public BaseResp delete(@RequestBody DeleteRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            paramValService.delete(request);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }
}

package com.ghostkang.mail_template_server.controller;

import com.ghostkang.mail_template_server.bean.BaseResp;
import com.ghostkang.mail_template_server.bean.goodclassify_param.*;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.service.GoodClassifyParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 分类参数 信息操作处理
 *
 * @author GhostKang
 * @date 2020-11-06 17:22:53
 */
@Controller
@RequestMapping("/good_classify_param")
public class GoodClassifyParamController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodClassifyParamService goodClassifyParamService;

    /**
     * 添加商品参数分类
     */
    @PostMapping("/add")
    @ResponseBody
    public BaseResp add(@RequestBody AddRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            goodClassifyParamService.add(request);
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
            goodClassifyParamService.edit(request);
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
            goodClassifyParamService.delete(request);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    @PostMapping("/list")
    @ResponseBody
    public BaseResp list(@RequestBody ListRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            List<ListResponse> list = goodClassifyParamService.list(request);
            baseResp.setData(list);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }
}

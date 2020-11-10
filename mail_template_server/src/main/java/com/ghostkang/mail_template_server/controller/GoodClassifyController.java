package com.ghostkang.mail_template_server.controller;

import com.ghostkang.mail_template_server.bean.BaseResp;
import com.ghostkang.mail_template_server.bean.goodclassify.AddRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.DeleteRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.EditRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.Response;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.service.GoodClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: GhostKang
 * @Date: 2020/11/5 17:42
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/good_classify")
public class GoodClassifyController {
    private static Logger logger = LoggerFactory.getLogger(GoodClassifyController.class);
    @Autowired
    private GoodClassifyService goodClassifyService;

    /**
     * 添加商品分类
     */
    @PostMapping("/add")
    @ResponseBody
    public BaseResp add(@RequestBody AddRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            goodClassifyService.add(request);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    /**
     * 删除商品分类
     */
    @PostMapping("/delete")
    @ResponseBody
    public BaseResp delete(@RequestBody DeleteRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            goodClassifyService.delete(request.getId());
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    /**
     * 编辑商品分类名称
     */
    @PostMapping("/edit")
    @ResponseBody
    public BaseResp delete(@RequestBody EditRequest request) {
        BaseResp baseResp = new BaseResp();
        try {
            goodClassifyService.edit(request);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }

    @PostMapping("/getAllGoodClassify")
    @ResponseBody
    public BaseResp getAllGoodClassify() {
        BaseResp baseResp = new BaseResp();
        List<Response> goodClassify = null;
        try {
            goodClassify = goodClassifyService.getGoodClassify();
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        baseResp.setData(goodClassify);
        return baseResp;
    }
}

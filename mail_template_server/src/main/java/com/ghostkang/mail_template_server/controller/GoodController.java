package com.ghostkang.mail_template_server.controller;

import com.ghostkang.mail_template_server.bean.BaseResp;
import com.ghostkang.mail_template_server.bean.good.ListRequest;
import com.ghostkang.mail_template_server.bean.good.ListResponse;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品 信息操作处理
 *
 * @author GhostKang
 * @date 2020-11-10 11:08:07
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodService goodService;

    @PostMapping("/list")
    @ResponseBody
    public BaseResp getGoodList(@RequestBody ListRequest request){
        BaseResp baseResp = new BaseResp();
        try {
            ListResponse goodList = goodService.getGoodList(request);
            baseResp.setData(goodList);
        } catch (ServiceException e) {
            baseResp.setCode(e.getCode());
            baseResp.setMsg(e.getMessage());
        }
        return baseResp;
    }
}

package com.ghostkang.mail_template_server.bean.good;

import com.ghostkang.mail_template_server.bean.PageResp;
import com.ghostkang.mail_template_server.domain.Good;

import java.util.List;

/**
 * @Author: GhostKang
 * @Date: 2020/11/10 14:56
 * @Description:
 * @Version: 1.0
 */
public class ListResponse extends PageResp {
    private List<GoodVo> goods;

    public List<GoodVo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodVo> goods) {
        this.goods = goods;
    }
}

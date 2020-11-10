package com.ghostkang.mail_template_server.dao;

import com.ghostkang.mail_template_server.bean.good.GoodVo;
import com.ghostkang.mail_template_server.bean.good.ListRequest;
import com.ghostkang.mail_template_server.bean.good.ListResponse;
import com.ghostkang.mail_template_server.domain.Good;
import com.ghostkang.mail_template_server.framework.core.Mapper;

import java.util.List;

/**
 * 商品 数据层
 * 
 * @author GhostKang
 * @date 2020-11-10 11:08:07
 */
public interface GoodDao extends Mapper<Good> {
	List<GoodVo> getGoodList(ListRequest listRequest);
}
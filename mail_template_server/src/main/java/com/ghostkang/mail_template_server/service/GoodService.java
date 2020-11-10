package com.ghostkang.mail_template_server.service;

import com.ghostkang.mail_template_server.bean.good.*;
import com.ghostkang.mail_template_server.domain.Good;
import com.ghostkang.mail_template_server.framework.core.Service;

import java.util.List;

/**
 * 商品 服务层
 *
 * @author GhostKang
 * @date 2020-11-10 11:08:07
 */
public interface GoodService extends Service<Good> {

    int add(AddRequest addRequest);

    int edit(EditRequest editRequest);

    int delete(Integer id);

    ListResponse getGoodList(ListRequest listRequest);
}

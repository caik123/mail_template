package com.ghostkang.mail_template_server.service;

import com.ghostkang.mail_template_server.bean.goodclassify_param.*;
import com.ghostkang.mail_template_server.domain.GoodClassifyParam;
import com.ghostkang.mail_template_server.framework.core.Service;

import java.util.List;

/**
 * 分类参数 服务层
 *
 * @author GhostKang
 * @date 2020-11-06 17:22:53
 */
public interface GoodClassifyParamService extends Service<GoodClassifyParam> {

    int add(AddRequest addRequest);

    int edit(EditRequest editRequest);

    int delete(DeleteRequest deleteRequest);

    List<ListResponse> list(ListRequest listRequest);
}

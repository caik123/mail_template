package com.ghostkang.mail_template_server.service;

import com.ghostkang.mail_template_server.bean.goodclassify.AddRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.EditRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.Response;
import com.ghostkang.mail_template_server.domain.GoodClassify;
import com.ghostkang.mail_template_server.framework.core.Service;

import java.util.List;

/**
 * @Author: GhostKang
 * @Date: 2020/11/5 17:43
 * @Description:
 * @Version: 1.0
 */
public interface GoodClassifyService extends Service<GoodClassify> {

    /***
     * 添加分类
     * @return
     */
    int add(AddRequest addRequest);

    /***
     * 删除分类
     * @param id 分类id
     * @return
     */
    int delete(int id);

    /***
     * 编辑分类名称
     * @param request request
     * @return
     */
    int edit(EditRequest request);

    /***
     * 获取所有商品分类
     */
    List<Response> getGoodClassify();

}

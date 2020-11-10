package com.ghostkang.mail_template_server.service;

import com.ghostkang.mail_template_server.bean.param_val.AddRequest;
import com.ghostkang.mail_template_server.bean.param_val.DeleteRequest;
import com.ghostkang.mail_template_server.bean.param_val.EditRequest;
import com.ghostkang.mail_template_server.domain.ParamVal;
import com.ghostkang.mail_template_server.framework.core.Service;

/**
 * 参数值 服务层
 *
 * @author GhostKang
 * @date 2020-11-09 14:05:18
 */
public interface ParamValService extends Service<ParamVal> {

    int add(AddRequest addRequest);

    int edit(EditRequest editRequest);

    int delete(DeleteRequest deleteRequest);
}

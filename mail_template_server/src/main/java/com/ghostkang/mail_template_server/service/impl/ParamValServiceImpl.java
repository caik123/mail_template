package com.ghostkang.mail_template_server.service.impl;


import com.ghostkang.mail_template_server.bean.param_val.AddRequest;
import com.ghostkang.mail_template_server.bean.param_val.DeleteRequest;
import com.ghostkang.mail_template_server.bean.param_val.EditRequest;
import com.ghostkang.mail_template_server.dao.ParamValDao;
import com.ghostkang.mail_template_server.domain.ParamVal;
import com.ghostkang.mail_template_server.framework.core.AbstractService;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.framework.result.ResultCode;
import com.ghostkang.mail_template_server.service.ParamValService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 参数值 服务层实现
 *
 * @author GhostKang
 * @date 2020-11-09 14:05:18
 */
@Service("paramValService")
//@Transactional
public class ParamValServiceImpl extends AbstractService<ParamVal> implements ParamValService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParamValDao paramValDao;


    @Override
    public int add(AddRequest addRequest) {
        if (addRequest.getParamId() == null || StringUtils.isEmpty(addRequest.getValName())) {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }
        ParamVal paramVal = new ParamVal();
        BeanUtils.copyProperties(addRequest, paramVal);
        return paramValDao.insertSelective(paramVal);
    }

    @Override
    public int edit(EditRequest editRequest) {
        if (editRequest.getId() == null || StringUtils.isEmpty(editRequest.getValName())) {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }
        ParamVal paramVal = paramValDao.selectByPrimaryKey(editRequest);
        if (paramVal == null) {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }
        paramVal.setValName(editRequest.getValName());
        return paramValDao.updateByPrimaryKey(paramVal);
    }

    @Override
    public int delete(DeleteRequest deleteRequest) {
        if (deleteRequest.getId() == null) {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }
        int effectNum = paramValDao.deleteByPrimaryKey(deleteRequest.getId());
        if (effectNum > 0) {
            return 1;
        } else {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }
    }
}

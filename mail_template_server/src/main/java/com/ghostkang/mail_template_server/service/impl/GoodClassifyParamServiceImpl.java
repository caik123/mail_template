package com.ghostkang.mail_template_server.service.impl;


import com.ghostkang.mail_template_server.bean.goodclassify_param.*;
import com.ghostkang.mail_template_server.dao.GoodClassifyParamDao;
import com.ghostkang.mail_template_server.domain.GoodClassifyParam;
import com.ghostkang.mail_template_server.domain.ParamVal;
import com.ghostkang.mail_template_server.framework.core.AbstractService;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.framework.result.ResultCode;
import com.ghostkang.mail_template_server.service.GoodClassifyParamService;
import com.ghostkang.mail_template_server.service.ParamValService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 分类参数 服务层实现
 *
 * @author GhostKang
 * @date 2020-11-06 17:22:53
 */
@Service("goodClassifyParamService")
@Transactional
public class GoodClassifyParamServiceImpl extends AbstractService<GoodClassifyParam> implements GoodClassifyParamService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodClassifyParamDao goodClassifyParamDao;

    @Autowired
    ParamValService paramValService;

    @Override
    public int add(AddRequest addRequest) {
        GoodClassifyParam goodClassifyParam = new GoodClassifyParam();
        BeanUtils.copyProperties(addRequest, goodClassifyParam);
        return goodClassifyParamDao.insertSelective(goodClassifyParam);
    }

    @Override
    public int edit(EditRequest editRequest) {
        GoodClassifyParam goodClassifyParam = goodClassifyParamDao.selectByPrimaryKey(editRequest);
        goodClassifyParam.setName(editRequest.getName());
        return goodClassifyParamDao.updateByPrimaryKey(goodClassifyParam);
    }

    @Override
    public int delete(DeleteRequest deleteRequest) {

        Example example = new Example(ParamVal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paramId", deleteRequest.getId());
        List<ParamVal> paramVals = paramValService.selectByExample(example);
        if (paramVals.size() > 0) {
            List<Integer> ids = paramVals.stream().map(item -> item.getId()).collect(Collectors.toList());
//            String collect = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
//            paramValService.deleteByIds(collect);
            ids.stream().forEach(item -> paramValService.deleteByPrimaryKey(item));
        }
        int i = goodClassifyParamDao.deleteByPrimaryKey(deleteRequest.getId());
        if (i > 0) {
            return 1;
        } else {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }

    }

    @Override
    public List<ListResponse> list(ListRequest listRequest) {
        List<ListResponse> responses = new ArrayList<>();

        Example example = new Example(GoodClassifyParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("goodClassifyId", listRequest.getClassifyId());
        criteria.andEqualTo("type", listRequest.getType());
        List<GoodClassifyParam> params = goodClassifyParamDao.selectByExample(example);

        for (GoodClassifyParam param : params) {
            ListResponse listResponse = new ListResponse();

            Example example1 = new Example(ParamVal.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("paramId", param.getId());
            List<ParamVal> paramVals = paramValService.selectByExample(example1);

            listResponse.setId(param.getId());
            listResponse.setName(param.getName());
            listResponse.setVals(paramVals);

            responses.add(listResponse);

        }

        return responses;
    }
}

package com.ghostkang.mail_template_server.service.impl;

import com.ghostkang.mail_template_server.bean.goodclassify.AddRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.EditRequest;
import com.ghostkang.mail_template_server.bean.goodclassify.Response;
import com.ghostkang.mail_template_server.dao.GoodClassifyDao;
import com.ghostkang.mail_template_server.domain.GoodClassify;
import com.ghostkang.mail_template_server.framework.core.AbstractService;
import com.ghostkang.mail_template_server.framework.exception.ServiceException;
import com.ghostkang.mail_template_server.framework.result.ResultCode;
import com.ghostkang.mail_template_server.service.GoodClassifyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: GhostKang
 * @Date: 2020/11/5 17:43
 * @Description:
 * @Version: 1.0
 */
@Service("goodClassifyService")
@Transactional
public class GoodClassifyServiceImpl extends AbstractService<GoodClassify> implements GoodClassifyService {
    private static Logger logger = LoggerFactory.getLogger(GoodClassifyServiceImpl.class);
    @Autowired
    private GoodClassifyDao goodClassifyDao;

    @Override
    public int add(AddRequest addRequest) {
        if (StringUtils.isEmpty(addRequest.getName())) {
            throw new ServiceException(ResultCode.PARAM_ERROR.code(), ResultCode.PARAM_ERROR.msg());
        }
        GoodClassify goodClassify = new GoodClassify();
        BeanUtils.copyProperties(addRequest, goodClassify);
        goodClassify.setCreated(new Date());
        goodClassify.setUpdated(new Date());
        //设置level
        GoodClassify pGoodClassify = goodClassifyDao.selectByPrimaryKey(addRequest.getPid());
        goodClassify.setLevel(pGoodClassify.getLevel() + 1);
        return goodClassifyDao.insertSelective(goodClassify);
    }

    @Override
    public int delete(int id) {
        GoodClassify goodClassify = goodClassifyDao.selectByPrimaryKey(id);
        if (goodClassify.getLevel() == 1) {
            Example example = new Example(GoodClassify.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("pid", goodClassify.getId());
            criteria.andEqualTo("level", 2);
            List<GoodClassify> goodClassifies = goodClassifyDao.selectByExample(example);
            goodClassifies.stream().forEach(item -> {
                item.setStatus(0);
                item.setUpdated(new Date());
                goodClassifyDao.updateByPrimaryKey(item);
            });
        } else if (goodClassify.getLevel() == 0) {
            Example example1 = new Example(GoodClassify.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("pid", goodClassify.getId());
            criteria1.andEqualTo("level", 1);
            List<GoodClassify> goodClassifies1 = goodClassifyDao.selectByExample(example1);//二级分类列表
            goodClassifies1.stream().forEach(item -> {
                Example example2 = new Example(GoodClassify.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("pid", item.getId());
                criteria2.andEqualTo("level", 2);
                List<GoodClassify> goodClassifies2 = goodClassifyDao.selectByExample(example2);//三级分类列表
                goodClassifies2.stream().forEach(item2 -> {
                    item2.setUpdated(new Date());
                    item2.setStatus(0);
                    goodClassifyDao.updateByPrimaryKey(item2);
                });
                item.setUpdated(new Date());
                item.setStatus(0);
                goodClassifyDao.updateByPrimaryKey(item);
            });
        }
        goodClassify.setStatus(0);
        goodClassify.setUpdated(new Date());
        return goodClassifyDao.updateByPrimaryKey(goodClassify);
    }

    @Override
    public int edit(EditRequest request) {
        GoodClassify goodClassify = goodClassifyDao.selectByPrimaryKey(request.getId());
        goodClassify.setName(request.getName());
        goodClassify.setUpdated(new Date());
        return goodClassifyDao.updateByPrimaryKey(goodClassify);
    }

    @Override
    public List<Response> getGoodClassify() {
        List<Response> resp = new ArrayList<>();

        //查找所有一级分类
        Example example = new Example(GoodClassify.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid", 0);
        criteria.andEqualTo("status", 1);
        List<GoodClassify> goodClassifies = goodClassifyDao.selectByExample(example);//一级分类列表
        //查找一级分类下的二级分类
        for (GoodClassify classify : goodClassifies) {
            Response resp1 = new Response();

            Example example1 = new Example(GoodClassify.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("pid", classify.getId());
            criteria1.andEqualTo("level", 1);
            criteria1.andEqualTo("status", 1);
            List<GoodClassify> goodClassifies1 = goodClassifyDao.selectByExample(example1);//二级分类列表

            List<Response> goodClassifyResps1 = goodClassifies1.stream().map(item -> {
                Response temp = new Response();
                BeanUtils.copyProperties(item, temp);
                return temp;
            }).collect(Collectors.toList());

            BeanUtils.copyProperties(classify, resp1);
            resp1.setChildren(goodClassifyResps1);

            resp.add(resp1);

            //查找二级分类下的三级分类
            List<Response> goodClassifies3 = new ArrayList<>();
            for (GoodClassify classify1 : goodClassifies1) {
                Response resp2 = new Response();

                Example example2 = new Example(GoodClassify.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("pid", classify1.getId());
                criteria2.andEqualTo("level", 2);
                criteria2.andEqualTo("status", 1);
                List<GoodClassify> goodClassifies2 = goodClassifyDao.selectByExample(example2);//三级分类列表

                List<Response> goodClassifyResps2 = goodClassifies2.stream().map(item -> {
                    Response temp = new Response();
                    BeanUtils.copyProperties(item, temp);
                    return temp;
                }).collect(Collectors.toList());

                BeanUtils.copyProperties(classify1, resp2);
                resp2.setChildren(goodClassifyResps2);

                goodClassifies3.add(resp2);

                resp1.setChildren(goodClassifies3);
            }
        }
        return resp;
    }
}

package com.ghostkang.mail_template_server.service.impl;


import com.ghostkang.mail_template_server.bean.good.*;
import com.ghostkang.mail_template_server.dao.GoodDao;
import com.ghostkang.mail_template_server.dao.GoodPicDao;
import com.ghostkang.mail_template_server.domain.Good;
import com.ghostkang.mail_template_server.domain.GoodPic;
import com.ghostkang.mail_template_server.framework.core.AbstractService;
import com.ghostkang.mail_template_server.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品 服务层实现
 *
 * @author GhostKang
 * @date 2020-11-10 11:08:07
 */
@Service("goodService")
@Transactional
public class GoodServiceImpl extends AbstractService<Good> implements GoodService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodDao goodDao;

    @Autowired
    private GoodPicDao goodPicDao;

    @Override
    public int add(AddRequest addRequest) {
        Good good = new Good();
        BeanUtils.copyProperties(addRequest,good);
        return goodDao.insertSelective(good);
    }

    @Override
    public int edit(EditRequest editRequest) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public ListResponse getGoodList(ListRequest listRequest) {
        ListResponse response = new ListResponse();
        //查询总条目数
        Good good = new Good();
        good.setStatus(listRequest.getStatus());
        int total = goodDao.selectCount(good);
        response.setTotal(total);
        response.setPage(listRequest.getPage());
        //查询列表
        GoodVo goodVo = new GoodVo();
        List<GoodVo> goodList = goodDao.getGoodList(listRequest);
        List<GoodVo> goodVos = goodList.stream().map(item->{
            BeanUtils.copyProperties(item,goodVo);
            Example example = new Example(GoodPic.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("goodId",item.getId());
            List<GoodPic> goodPics = goodPicDao.selectByExample(example);
            goodVo.setPics(goodPics.stream().map(path->path.getPic()).collect(Collectors.toList()));
            return goodVo;
        }).collect(Collectors.toList());
        response.setGoods(goodVos);
        return response;
    }
}

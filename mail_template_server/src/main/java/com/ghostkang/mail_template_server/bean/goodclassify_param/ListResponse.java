package com.ghostkang.mail_template_server.bean.goodclassify_param;

import com.ghostkang.mail_template_server.domain.ParamVal;

import java.util.List;

/**
 * @Author: GhostKang
 * @Date: 2020/11/9 14:34
 * @Description:
 * @Version: 1.0
 */
public class ListResponse {
    private Integer id;
    private String name;
    private List<ParamVal> vals;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParamVal> getVals() {
        return vals;
    }

    public void setVals(List<ParamVal> vals) {
        this.vals = vals;
    }
}

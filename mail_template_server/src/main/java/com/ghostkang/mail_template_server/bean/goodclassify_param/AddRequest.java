package com.ghostkang.mail_template_server.bean.goodclassify_param;

/**
 * @Author: GhostKang
 * @Date: 2020/11/9 13:40
 * @Description:
 * @Version: 1.0
 */
public class AddRequest {
    private Integer goodClassifyId;
    private String name;
    private Integer type;

    public Integer getGoodClassifyId() {
        return goodClassifyId;
    }

    public void setGoodClassifyId(Integer goodClassifyId) {
        this.goodClassifyId = goodClassifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

package com.ghostkang.mail_template_server.bean.goodclassify_param;

/**
 * @Author: GhostKang
 * @Date: 2020/11/9 14:26
 * @Description:
 * @Version: 1.0
 */
public class ListRequest {
    private Integer classifyId;
    private Integer type;

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

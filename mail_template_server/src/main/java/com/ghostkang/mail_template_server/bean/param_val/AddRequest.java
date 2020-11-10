package com.ghostkang.mail_template_server.bean.param_val;

/**
 * @Author: GhostKang
 * @Date: 2020/11/9 14:26
 * @Description:
 * @Version: 1.0
 */
public class AddRequest {
    private Integer paramId;
    private String valName;


    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getValName() {
        return valName;
    }

    public void setValName(String valName) {
        this.valName = valName;
    }
}

package com.ghostkang.mail_template_server.bean.param_val;

/**
 * @Author: GhostKang
 * @Date: 2020/11/9 14:26
 * @Description:
 * @Version: 1.0
 */
public class EditRequest {
    private Integer id;
    private String valName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValName() {
        return valName;
    }

    public void setValName(String valName) {
        this.valName = valName;
    }
}

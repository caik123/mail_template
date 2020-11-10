package com.ghostkang.mail_template_server.domain;

import javax.persistence.*;

/**
 * 参数值表 param_val
 *
 * @author GhostKang
 * @date 2020-11-09 14:05:18
 */
@Table(name = "`param_val`")
public class ParamVal {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Integer id;
    /**
     * 商品参数值对应的id（good_classify_param中的主键）
     */
    @Column(name = "`param_id`")
    private Integer paramId;
    /**
     * 商品参数值对应的name
     */
    @Column(name = "`val_name`")
    private String valName;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public void setValName(String valName) {
        this.valName = valName;
    }

    public String getValName() {
        return valName;
    }

    @Override
    public String toString() {
        return "ParamVal{" +
                "id=" + id +
                "paramId=" + paramId +
                "valName=" + valName +
                "}";
    }
}

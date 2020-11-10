package com.ghostkang.mail_template_server.bean.good;

import java.math.BigDecimal;

/**
 * @Author: GhostKang
 * @Date: 2020/11/10 11:12
 * @Description:
 * @Version: 1.0
 */
public class AddRequest {
    private String name;
    private BigDecimal originalPrice;
    private BigDecimal price;
    private Integer amount;
    private Integer classifyId;
    private String valId;//多个id，以逗号分隔
    private String description;
    private Integer isPromote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getValId() {
        return valId;
    }

    public void setValId(String valId) {
        this.valId = valId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsPromote(Integer isPromote) {
        this.isPromote = isPromote;
    }
}

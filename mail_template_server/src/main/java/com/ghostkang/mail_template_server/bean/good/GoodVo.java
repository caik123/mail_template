package com.ghostkang.mail_template_server.bean.good;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: GhostKang
 * @Date: 2020/11/10 15:01
 * @Description:
 * @Version: 1.0
 */
public class GoodVo {
    private Integer id;

    private String name;

    private BigDecimal price;

    private BigDecimal originalPrice;

    private Integer amount;

    private Integer classifyId;

    private String valId;

    private String description;

    private Integer status;

    private Integer isPromote;

    private Integer sort;

    private Date updated;

    private Date created;

    private List<String> pics;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Integer isPromote) {
        this.isPromote = isPromote;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    @Override
    public String toString() {
        return "GoodVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", amount=" + amount +
                ", classifyId=" + classifyId +
                ", valId='" + valId + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", isPromote=" + isPromote +
                ", sort=" + sort +
                ", updated=" + updated +
                ", created=" + created +
                ", pics=" + pics +
                '}';
    }
}

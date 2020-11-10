package com.ghostkang.mail_template_server.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表 good
 *
 * @author GhostKang
 * @date 2020-11-10 11:08:07
 */
@Table(name = "`good`")
public class Good {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Integer id;
    /**
     * 商品名称
     */
    @Column(name = "`name`")
    private String name;
    /**
     * 商品价格
     */
    @Column(name = "`price`")
    private BigDecimal price;
    /**
     * 商品原价格
     */
    @Column(name = "`original_price`")
    private BigDecimal originalPrice;
    /**
     * 商品数量
     */
    @Column(name = "`amount`")
    private Integer amount;
    /**
     * 分类id（对应good_classify表主键）
     */
    @Column(name = "`classify_id`")
    private Integer classifyId;
    /**
     * 参数id（对应param_val主键），以逗号分隔
     */
    @Column(name = "`val_id`")
    private String valId;
    /**
     * 描述
     */
    @Column(name = "`description`")
    private String description;
    /**
     * 商品状态；0-删除，1-上架，2-下架
     */
    @Column(name = "`status`")
    private Integer status;
    /**
     * 是否促销；0-不促销，1-促销
     */
    @Column(name = "`is_promote`")
    private Integer isPromote;
    /**
     * 排序，值越大权重越高
     */
    @Column(name = "`sort`")
    private Integer sort;
    /**
     *
     */
    @Column(name = "`updated`")
    private Date updated;
    /**
     *
     */
    @Column(name = "`created`")
    private Date created;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setValId(String valId) {
        this.valId = valId;
    }

    public String getValId() {
        return valId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setIsPromote(Integer isPromote) {
        this.isPromote = isPromote;
    }

    public Integer getIsPromote() {
        return isPromote;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                "name=" + name +
                "price=" + price +
                "originalPrice=" + originalPrice +
                "amount=" + amount +
                "classifyId=" + classifyId +
                "valId=" + valId +
                "description=" + description +
                "status=" + status +
                "isPromote=" + isPromote +
                "sort=" + sort +
                "updated=" + updated +
                "created=" + created +
                "}";
    }
}

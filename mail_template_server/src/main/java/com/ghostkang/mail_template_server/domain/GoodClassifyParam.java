package com.ghostkang.mail_template_server.domain;

import javax.persistence.*;
import java.util.Date;
/**
 * 分类参数表 good_classify_param
 * 
 * @author GhostKang
 * @date 2020-11-09 14:04:06
 */
@Table(name = "`good_classify_param`")
public class GoodClassifyParam {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`")
	private Integer id;
	/**
	 * 商品分类id（good_classify主键）
	 */
	@Column(name = "`good_classify_id`")
	private Integer goodClassifyId;
	/**
	 * 1-静态属性，2-动态参数；
	 */
	@Column(name = "`type`")
	private Integer type;
	/**
	 * 参数名称
	 */
	@Column(name = "`name`")
	private String name;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setGoodClassifyId(Integer goodClassifyId) {
		this.goodClassifyId = goodClassifyId;
	}

	public Integer getGoodClassifyId() {
		return goodClassifyId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
    public String toString() {
        return "GoodClassifyParam{" +
        		"id=" + id +
        		"goodClassifyId=" + goodClassifyId +
        		"type=" + type +
        		"name=" + name +
				"}";
    }
}

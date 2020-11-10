package com.ghostkang.mail_template_server.domain;

import javax.persistence.*;
import java.util.Date;
/**
 * 商品分类表 good_classify
 *
 * @author GhostKang
 * @date 2020-11-06 10:39:07
 */
@Table(name = "`good_classify`")
public class GoodClassify {
	/**
	 * 主键
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
	 * 父类id
	 */
	@Column(name = "`pid`")
	private Integer pid;
	/**
	 * 级别；0-一级、1-二级，2-三级
	 */
	@Column(name = "`level`")
	private Integer level;
	/**
	 * 图片路径
	 */
	@Column(name = "`icon`")
	private String icon;
	/**
	 * 排序；数值越小权重越大
	 */
	@Column(name = "`sort`")
	private Integer sort;
	/**
	 * 状态；0-已删除，1-未删除
	 */
	@Column(name = "`status`")
	private Integer status;
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

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
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
		return "GoodClassify{" +
				"id=" + id +
				"name=" + name +
				"pid=" + pid +
				"level=" + level +
				"icon=" + icon +
				"sort=" + sort +
				"status=" + status +
				"updated=" + updated +
				"created=" + created +
				"}";
	}
}

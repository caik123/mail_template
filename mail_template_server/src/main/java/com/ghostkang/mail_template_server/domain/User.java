package com.ghostkang.mail_template_server.domain;

import javax.persistence.*;
import java.util.Date;
/**
 * 表 user
 * 
 * @author GhostKang
 * @date 2020-11-06 10:59:39
 */
@Table(name = "`user`")
public class User {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`")
	private Integer id;
	/**
	 * 用户名，登录账号，唯一
	 */
	@Id
	@Column(name = "`username`")
	private String username;
	/**
	 * 电话
	 */
	@Id
	@Column(name = "`cellphonoe`")
	private String cellphonoe;
	/**
	 * 密码
	 */
	@Column(name = "`password`")
	private String password;
	/**
	 * 昵称
	 */
	@Column(name = "`nickname`")
	private String nickname;
	/**
	 * 头像
	 */
	@Column(name = "`avatar`")
	private String avatar;
	/**
	 * 性别；1-男，2-女，3-未知
	 */
	@Column(name = "`sex`")
	private Integer sex;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setCellphonoe(String cellphonoe) {
		this.cellphonoe = cellphonoe;
	}

	public String getCellphonoe() {
		return cellphonoe;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return sex;
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
        return "User{" +
        		"id=" + id +
        		"username=" + username +
        		"cellphonoe=" + cellphonoe +
        		"password=" + password +
        		"nickname=" + nickname +
        		"avatar=" + avatar +
        		"sex=" + sex +
        		"updated=" + updated +
        		"created=" + created +
				"}";
    }
}

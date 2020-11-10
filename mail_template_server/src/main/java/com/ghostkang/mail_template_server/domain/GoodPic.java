package com.ghostkang.mail_template_server.domain;

import javax.persistence.*;
import java.util.Date;
/**
 * 表 good_pic
 * 
 * @author GhostKang
 * @date 2020-11-10 16:28:08
 */
@Table(name = "`good_pic`")
public class GoodPic {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`")
	private Integer id;
	/**
	 * 商品id，对应good表主键
	 */
	@Column(name = "`good_id`")
	private Integer goodId;
	/**
	 * 图片地址
	 */
	@Column(name = "`pic`")
	private String pic;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	@Override
    public String toString() {
        return "GoodPic{" +
        		"id=" + id +
        		"goodId=" + goodId +
        		"pic=" + pic +
				"}";
    }
}

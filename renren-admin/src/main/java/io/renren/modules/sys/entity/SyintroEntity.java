package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 论思简介
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Data
@TableName("tb_syintro")
public class SyintroEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 论思简介id
	 */
	@TableId
	private Integer introid;
	/**
	 * 论思简介内容
	 */
	private String introcontent;
	/**
	 * 论思简介图片地址
	 */
	private String imgaddress;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getIntroid() {
		return introid;
	}

	public void setIntroid(Integer introid) {
		this.introid = introid;
	}

	public String getIntrocontent() {
		return introcontent;
	}

	public void setIntrocontent(String introcontent) {
		this.introcontent = introcontent;
	}

	public String getImgaddress() {
		return imgaddress;
	}

	public void setImgaddress(String imgaddress) {
		this.imgaddress = imgaddress;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}

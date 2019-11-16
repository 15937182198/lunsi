package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 教学理念
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@Data
@TableName("tb_gyidea")
public class GyideaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 教学理念
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 图片地址
	 */
	private String address;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

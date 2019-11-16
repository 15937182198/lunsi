package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 高考环境
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@Data
@TableName("tb_syenvironment")
public class SyenvironmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 改字段是图片地址，如果是多图需要将多图地址集合转换成字符串
	 */
	private String imgaddress;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 高考环境介绍
	 */
	private String content;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

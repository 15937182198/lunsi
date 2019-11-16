package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ,艺考生高考成绩展示
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Data
@TableName("tb_ykstudentreport")
public class YkstudentreportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 图片地址
	 */
	private String imgaddress;
	/**
	 * 分数
	 */
	private Integer score;
	/**
	 * 学生名
	 */
	private String studentname;
	/**
	 * 学生简介
	 */
	private String studentintro;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

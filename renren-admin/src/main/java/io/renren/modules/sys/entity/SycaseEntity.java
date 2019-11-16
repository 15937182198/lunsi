package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 论思案例
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Data
@TableName("tb_sycase")
public class SycaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 案例id
	 */
	@TableId
	private Integer caseid;
	/**
	 * 论思案例学生姓名
	 */
	private String casestudentname;
	/**
	 * 论思案例时间
	 */
	private Date casetime;
	/**
	 * 论思案例内容
	 */
	private String casecontent;
	/**
	 * 论思案例图片地址
	 */
	private String caseimgaddress;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

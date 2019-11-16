package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 论思四必方针
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
@Data
@TableName("tb_jxpolicy")
public class JxpolicyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 标题 可以是数字
	 */
	private String title;
	/**
	 * 内容
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

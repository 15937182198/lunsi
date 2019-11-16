package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 论思教学法
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
@Data
@TableName("tb_gyteachmethod")
public class GyteachmethodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 中间大标题
	 */
	private String title1;
	/**
	 * 两边小标题
	 */
	private String title2;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 老师端还是学生端
	 */
	private String teacherorstudent;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

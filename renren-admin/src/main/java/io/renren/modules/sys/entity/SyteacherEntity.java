package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 高考团队老师
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Data
@TableName("tb_syteacher")
public class SyteacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 高考团队老师Id
	 */
	@TableId
	private Integer teacherid;
	/**
	 * 老师姓名
	 */
	private String teachername;
	/**
	 * 老师简介
	 */
	private String teacherintro;
	/**
	 * 老师讲课风格
	 */
	private String teacherstyle;
	/**
	 * 老师对学生的一句话
	 */
	private String teacherforstudent;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

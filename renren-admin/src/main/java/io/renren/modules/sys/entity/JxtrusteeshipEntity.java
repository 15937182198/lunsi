package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 那些高考适合托管集训
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
@Data
@TableName("tb_jxtrusteeship")
public class JxtrusteeshipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 顺序
	 */
	private Integer nid;
	/**
	 * 标题
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

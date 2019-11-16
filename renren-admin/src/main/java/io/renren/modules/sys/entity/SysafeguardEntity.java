package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 此表是八大保障
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@Data
@TableName("tb_sysafeguard")
public class SysafeguardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 保障id
	 */
	@TableId
	private Integer id;
	/**
	 * 类别，如果是课前环节等就为1，如果是保障为2，如果是保障内容为3
	 */
	private Integer sort;
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

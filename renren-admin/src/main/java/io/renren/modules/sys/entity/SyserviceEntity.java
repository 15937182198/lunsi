package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 高考一站式服务
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
@Data
@TableName("tb_syservice")
public class SyserviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 服务id
	 */
	@TableId
	private Integer serviceid;
	/**
	 * 高考一站式服务图片地址
	 */
	private String serviceimgaddress;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}

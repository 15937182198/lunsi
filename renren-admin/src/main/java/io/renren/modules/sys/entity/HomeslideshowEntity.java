package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Data
@TableName("tb_homeslideshow")
public class HomeslideshowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 轮播图id
	 */
	@TableId
	private Integer id;
	/**
	 * 轮播图地址
	 */
	private String address;
	/**
	 * 轮播图属于哪个页面
	 */
	private String pagenumber;
	/**
	 * 图片添加时间
	 */
	private Date addtime;
	/**
	 * 图片修改时间
	 */
	private Date updatetime;

}

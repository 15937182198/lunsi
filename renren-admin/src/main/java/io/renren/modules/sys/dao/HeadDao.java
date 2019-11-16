package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.HeadEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 论思页面头部信息
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:05
 */
@Mapper
public interface HeadDao extends BaseMapper<HeadEntity> {
	
}

package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 报名学生信息
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}

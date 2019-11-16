package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.StudentEntity;

import java.util.Map;

/**
 * 报名学生信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


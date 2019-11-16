package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SyteacherEntity;

import java.util.Map;

/**
 * 高考团队老师
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface SyteacherService extends IService<SyteacherEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


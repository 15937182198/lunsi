package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.GymeaningEntity;

import java.util.Map;

/**
 * 论思教学意义
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
public interface GymeaningService extends IService<GymeaningEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


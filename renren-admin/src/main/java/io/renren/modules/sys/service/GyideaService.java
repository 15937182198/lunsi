package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.GyideaEntity;

import java.util.Map;

/**
 * 教学理念
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
public interface GyideaService extends IService<GyideaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


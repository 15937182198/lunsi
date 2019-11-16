package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SyserviceEntity;

import java.util.Map;

/**
 * 高考一站式服务
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
public interface SyserviceService extends IService<SyserviceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


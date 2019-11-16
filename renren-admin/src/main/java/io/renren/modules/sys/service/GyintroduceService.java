package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.GyintroduceEntity;

import java.util.Map;

/**
 * 论思介绍
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
public interface GyintroduceService extends IService<GyintroduceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


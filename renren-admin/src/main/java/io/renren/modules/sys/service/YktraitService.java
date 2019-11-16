package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.YktraitEntity;

import java.util.Map;

/**
 * 只讲必考点,不讲无关知识
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
public interface YktraitService extends IService<YktraitEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


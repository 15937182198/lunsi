package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.HomeslideshowEntity;

import java.util.Map;

/**
 * 轮播图
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface HomeslideshowService extends IService<HomeslideshowEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


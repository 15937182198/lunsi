package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SycaseEntity;

import java.util.Map;

/**
 * 论思案例
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface SycaseService extends IService<SycaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


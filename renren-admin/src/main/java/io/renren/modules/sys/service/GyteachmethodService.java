package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.GyteachmethodEntity;

import java.util.Map;

/**
 * 论思教学法
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
public interface GyteachmethodService extends IService<GyteachmethodEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


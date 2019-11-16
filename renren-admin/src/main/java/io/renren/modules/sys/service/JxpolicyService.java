package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.JxpolicyEntity;

import java.util.Map;

/**
 * 论思四必方针
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
public interface JxpolicyService extends IService<JxpolicyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


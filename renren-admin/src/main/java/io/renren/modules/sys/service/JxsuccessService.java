package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.JxsuccessEntity;

import java.util.Map;

/**
 * 论思创新
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
public interface JxsuccessService extends IService<JxsuccessEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


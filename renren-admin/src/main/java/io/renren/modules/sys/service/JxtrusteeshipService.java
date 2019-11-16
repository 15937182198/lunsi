package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.JxtrusteeshipEntity;

import java.util.Map;

/**
 * 那些高考适合托管集训
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
public interface JxtrusteeshipService extends IService<JxtrusteeshipEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


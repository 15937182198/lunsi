package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.JxenvironmentEntity;

import java.util.Map;

/**
 * 高考集训页面环境展示
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:11
 */
public interface JxenvironmentService extends IService<JxenvironmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


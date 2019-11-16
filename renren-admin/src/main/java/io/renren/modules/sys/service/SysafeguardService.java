package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysafeguardEntity;

import java.util.Map;

/**
 * 此表是八大保障
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
public interface SysafeguardService extends IService<SysafeguardEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SystudentaddressEntity;

import java.util.Map;

/**
 * 地址信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:12
 */
public interface SystudentaddressService extends IService<SystudentaddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


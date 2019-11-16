package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.HeadEntity;

import java.util.Map;

/**
 * 论思页面头部信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:05
 */
public interface HeadService extends IService<HeadEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


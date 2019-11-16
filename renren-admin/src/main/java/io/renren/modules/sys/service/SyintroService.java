package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SyintroEntity;

import java.util.Map;

/**
 * 论思简介
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface SyintroService extends IService<SyintroEntity> {

    PageUtils queryPage(Map<String, Object> params);

    public boolean updateById1(SyintroEntity entity);
}


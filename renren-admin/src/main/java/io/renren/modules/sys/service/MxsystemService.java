package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MxsystemEntity;

import java.util.Map;

/**
 * 学霸四大管理体系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface MxsystemService extends IService<MxsystemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


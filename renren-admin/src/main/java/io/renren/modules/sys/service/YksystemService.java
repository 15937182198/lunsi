package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.YksystemEntity;

import java.util.Map;

/**
 * 艺考生文化课集训高效管理体系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface YksystemService extends IService<YksystemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


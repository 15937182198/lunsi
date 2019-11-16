package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.YktextbookEntity;

import java.util.Map;

/**
 * 艺考文化课权威教材
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
public interface YktextbookService extends IService<YktextbookEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


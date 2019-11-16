package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.YkimgEntity;

import java.util.Map;

/**
 * 论思高考为艺考生定制专属课程
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:21
 */
public interface YkimgService extends IService<YkimgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


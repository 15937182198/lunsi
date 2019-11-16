package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.YkstudentreportEntity;

import java.util.Map;

/**
 * ,艺考生高考成绩展示
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface YkstudentreportService extends IService<YkstudentreportEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


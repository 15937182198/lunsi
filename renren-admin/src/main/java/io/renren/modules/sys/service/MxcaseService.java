package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MxcaseEntity;

import java.util.Map;

/**
 * 学霸逆袭案例
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface MxcaseService extends IService<MxcaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


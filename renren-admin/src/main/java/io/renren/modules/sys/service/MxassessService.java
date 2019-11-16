package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MxassessEntity;

import java.util.Map;

/**
 * 学霸四大评估体系
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-11-15 10:54:09
 */
public interface MxassessService extends IService<MxassessEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SysafeguardDao;
import io.renren.modules.sys.entity.SysafeguardEntity;
import io.renren.modules.sys.service.SysafeguardService;


@Service("sysafeguardService")
public class SysafeguardServiceImpl extends ServiceImpl<SysafeguardDao, SysafeguardEntity> implements SysafeguardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysafeguardEntity> page = this.page(
                new Query<SysafeguardEntity>().getPage(params),
                new QueryWrapper<SysafeguardEntity>()
        );

        return new PageUtils(page);
    }

}

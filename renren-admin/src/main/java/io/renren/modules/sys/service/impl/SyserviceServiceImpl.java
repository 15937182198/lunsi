package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SyserviceDao;
import io.renren.modules.sys.entity.SyserviceEntity;
import io.renren.modules.sys.service.SyserviceService;


@Service("syserviceService")
public class SyserviceServiceImpl extends ServiceImpl<SyserviceDao, SyserviceEntity> implements SyserviceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SyserviceEntity> page = this.page(
                new Query<SyserviceEntity>().getPage(params),
                new QueryWrapper<SyserviceEntity>()
        );

        return new PageUtils(page);
    }

}

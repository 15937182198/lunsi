package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SycaseDao;
import io.renren.modules.sys.entity.SycaseEntity;
import io.renren.modules.sys.service.SycaseService;


@Service("sycaseService")
public class SycaseServiceImpl extends ServiceImpl<SycaseDao, SycaseEntity> implements SycaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SycaseEntity> page = this.page(
                new Query<SycaseEntity>().getPage(params),
                new QueryWrapper<SycaseEntity>()
        );

        return new PageUtils(page);
    }

}

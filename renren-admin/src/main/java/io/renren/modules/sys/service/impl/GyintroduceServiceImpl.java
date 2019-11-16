package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.GyintroduceDao;
import io.renren.modules.sys.entity.GyintroduceEntity;
import io.renren.modules.sys.service.GyintroduceService;


@Service("gyintroduceService")
public class GyintroduceServiceImpl extends ServiceImpl<GyintroduceDao, GyintroduceEntity> implements GyintroduceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyintroduceEntity> page = this.page(
                new Query<GyintroduceEntity>().getPage(params),
                new QueryWrapper<GyintroduceEntity>()
        );

        return new PageUtils(page);
    }

}

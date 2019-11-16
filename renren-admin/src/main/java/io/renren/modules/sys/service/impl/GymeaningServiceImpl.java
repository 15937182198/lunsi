package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.GymeaningDao;
import io.renren.modules.sys.entity.GymeaningEntity;
import io.renren.modules.sys.service.GymeaningService;


@Service("gymeaningService")
public class GymeaningServiceImpl extends ServiceImpl<GymeaningDao, GymeaningEntity> implements GymeaningService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GymeaningEntity> page = this.page(
                new Query<GymeaningEntity>().getPage(params),
                new QueryWrapper<GymeaningEntity>()
        );

        return new PageUtils(page);
    }

}

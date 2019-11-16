package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.GyideaDao;
import io.renren.modules.sys.entity.GyideaEntity;
import io.renren.modules.sys.service.GyideaService;


@Service("gyideaService")
public class GyideaServiceImpl extends ServiceImpl<GyideaDao, GyideaEntity> implements GyideaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyideaEntity> page = this.page(
                new Query<GyideaEntity>().getPage(params),
                new QueryWrapper<GyideaEntity>()
        );

        return new PageUtils(page);
    }

}

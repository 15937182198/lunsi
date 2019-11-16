package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SyenvironmentDao;
import io.renren.modules.sys.entity.SyenvironmentEntity;
import io.renren.modules.sys.service.SyenvironmentService;


@Service("syenvironmentService")
public class SyenvironmentServiceImpl extends ServiceImpl<SyenvironmentDao, SyenvironmentEntity> implements SyenvironmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SyenvironmentEntity> page = this.page(
                new Query<SyenvironmentEntity>().getPage(params),
                new QueryWrapper<SyenvironmentEntity>()
        );

        return new PageUtils(page);
    }

}

package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.JxenvironmentDao;
import io.renren.modules.sys.entity.JxenvironmentEntity;
import io.renren.modules.sys.service.JxenvironmentService;


@Service("jxenvironmentService")
public class JxenvironmentServiceImpl extends ServiceImpl<JxenvironmentDao, JxenvironmentEntity> implements JxenvironmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JxenvironmentEntity> page = this.page(
                new Query<JxenvironmentEntity>().getPage(params),
                new QueryWrapper<JxenvironmentEntity>()
        );

        return new PageUtils(page);
    }

}
